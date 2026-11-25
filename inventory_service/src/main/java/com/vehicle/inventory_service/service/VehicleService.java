package com.vehicle.inventory_service.service;


import com.vehicle.inventory_service.dto.VehicleQuickResponse;
import com.vehicle.inventory_service.dto.VehicleRequest;
import com.vehicle.inventory_service.dto.VehicleResponse;
import com.vehicle.inventory_service.model.Vehicle;
import com.vehicle.inventory_service.repository.VehicleRepository;
import com.vehicle.inventory_service.util.VehicleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public void insertVehicle(VehicleRequest request) {
        Vehicle vehicle = VehicleMapper.buildVehicleFromRequest(request);
        vehicleRepository.save(vehicle);
    }

    public VehicleResponse getVehicleByVin(String vin) {
        Optional<Vehicle> vehicle = vehicleRepository.findByVin(vin);
        if (vehicle.isPresent()) {
            return VehicleMapper.buildVehicleResponse(vehicle.get());
        }
        return null;
    }

    public List<VehicleQuickResponse> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles.stream().map(v -> new VehicleQuickResponse(v.getMake().getName(), v.getModel().getName(), v.getTrim().getYear(), v.getBody().getType())).toList();
    }
}
