package com.vehicle.inventory_service.exception;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Regex to extract the duplicate key field and value from MongoDB's error message
    private static final Pattern DUP_KEY_PATTERN = Pattern.compile("dup key: \\{\\s*([^:]+):\\s*\"?([^\"}]+)\"?\\s*\\}");

    @ExceptionHandler(DuplicateKeyException.class)
    public ProblemDetail handleDuplicateKeyException(DuplicateKeyException ex) {
        String message = "A record with the same unique identifier already exists.";

        // Extract specific field and value (e.g., vin: "67XCBRSP6B0987648") if available
        if (ex.getMessage() != null) {
            Matcher matcher = DUP_KEY_PATTERN.matcher(ex.getMessage());
            if (matcher.find()) {
                String field = matcher.group(1).trim();
                String value = matcher.group(2).trim();
                message = String.format("Duplicate value '%s' for unique field '%s'.", value, field);
            }
        }

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, message);
        problemDetail.setTitle("Duplicate Resource");
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }
}

