package com.vehicle.inventory_service.repository;


import com.vehicle.inventory_service.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface VehicleRepository extends MongoRepository<Vehicle, String> {
    Optional<Vehicle> findByVin(String vin);
}
