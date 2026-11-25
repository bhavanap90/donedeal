package controller;

import dto.VehicleQuickResponse;
import dto.VehicleRequest;
import dto.VehicleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import service.VehicleService;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vehicle")
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void insertVehicle(@RequestBody VehicleRequest vehicleRequest) {
        vehicleService.insertVehicle(vehicleRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public VehicleResponse getVehicle(@RequestParam(name="vin") String vin) {
        return vehicleService.getVehicleByVin(vin);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<VehicleQuickResponse> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }
}
