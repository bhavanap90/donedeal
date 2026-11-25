package com.vehicle.inventory_service.controller;

import com.vehicle.inventory_service.dto.VehicleQuickResponse;
import com.vehicle.inventory_service.dto.VehicleRequest;
import com.vehicle.inventory_service.dto.VehicleResponse;
import com.vehicle.inventory_service.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping("/vehicle")
    @ResponseStatus(HttpStatus.CREATED)
    public void insertVehicle(@RequestBody VehicleRequest vehicleRequest) {
        vehicleService.insertVehicle(vehicleRequest);
    }

    @GetMapping("/vehicle")
    @ResponseStatus(HttpStatus.OK)
    public VehicleResponse getVehicle(@RequestParam(name = "vin") String vin) {
        return vehicleService.getVehicleByVin(vin);
    }

    @GetMapping("/vehicles")
    @ResponseStatus(HttpStatus.OK)
    public List<VehicleQuickResponse> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }
}
