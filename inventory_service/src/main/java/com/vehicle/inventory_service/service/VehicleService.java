package service;

import dto.VehicleQuickResponse;
import dto.VehicleRequest;
import dto.VehicleResponse;
import lombok.RequiredArgsConstructor;
import model.Vehicle;
import org.springframework.stereotype.Service;
import repository.VehicleRepository;
import util.VehicleMapper;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public void insertVehicle(VehicleRequest request) {
        Vehicle vehicle = VehicleMapper.buildVehicleFromRequest(request);
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
