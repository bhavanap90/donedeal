package com.vehicle.inventory_service.util;

import com.vehicle.inventory_service.dto.VehicleRequest;
import com.vehicle.inventory_service.dto.VehicleResponse;
import com.vehicle.inventory_service.model.Vehicle;


public class VehicleMapper {
    public static Vehicle buildVehicleFromRequest(VehicleRequest request) {
        return Vehicle.builder()
                .vin(request.vin())
                .make(Vehicle.Make.builder()
                        .id(request.makeId())
                        .name(request.makeName())
                        .build())
                .model(Vehicle.Model.builder()
                        .id(request.modelId())
                        .name(request.modelName())
                        .build())
                .trim(Vehicle.Trim.builder()
                        .id(request.trimId())
                        .year(request.trimYear())
                        .name(request.trimName())
                        .description(request.trimDescription())
                        .msrp(request.trimMsrp())
                        .invoice(request.trimInvoice())
                        .build())
                .engine(Vehicle.Engine.builder()
                        .id(request.engineId())
                        .type(request.engineType())
                        .fuelType(request.engineFuelType())
                        .cylinders(request.engineCylinders())
                        .size(request.engineSize())
                        .horsepowerHp(request.engineHorsepowerHp())
                        .horsepowerRpm(request.engineHorsepowerRpm())
                        .torqueFtLbs(request.engineTorqueFtLbs())
                        .torqueRpm(request.engineTorqueRpm())
                        .valves(request.engineValves())
                        .valveTiming(request.engineValveTiming())
                        .camType(request.engineCamType())
                        .driveType(request.engineDriveType())
                        .transmission(request.engineTransmission())
                        .build())
                .body(Vehicle.Body.builder()
                        .id(request.bodyId())
                        .type(request.bodyType())
                        .doors(request.bodyDoors())
                        .seats(request.bodySeats())
                        .length(request.bodyLength())
                        .width(request.bodyWidth())
                        .height(request.bodyHeight())
                        .wheelBase(request.bodyWheelBase())
                        .frontTrack(request.bodyFrontTrack())
                        .rearTrack(request.bodyRearTrack())
                        .groundClearance(request.bodyGroundClearance())
                        .cargoCapacity(request.bodyCargoCapacity())
                        .maxCargoCapacity(request.bodyMaxCargoCapacity())
                        .curbWeight(request.bodyCurbWeight())
                        .grossWeight(request.bodyGrossWeight())
                        .maxPayload(request.bodyMaxPayload())
                        .maxTowingCapacity(request.bodyMaxTowingCapacity())
                        .build())
                .mileage(Vehicle.Mileage.builder()
                        .id(request.mileageId())
                        .fuelTankCapacity(request.mileageFuelTankCapacity())
                        .combinedMpg(request.mileageCombinedMpg())
                        .epaCityMpg(request.mileageEpaCityMpg())
                        .epaHighwayMpg(request.mileageEpaHighwayMpg())
                        .rangeCity(request.mileageRangeCity())
                        .rangeHighway(request.mileageRangeHighway())
                        .build())
                .build();
    }

    public static VehicleResponse buildVehicleResponse(Vehicle vehicle) {
        if (vehicle == null) {
            return null;
        }
        Vehicle.Make make = vehicle.getMake();
        Vehicle.Model model = vehicle.getModel();
        Vehicle.Trim trim = vehicle.getTrim();
        Vehicle.Engine engine = vehicle.getEngine();
        Vehicle.Body body = vehicle.getBody();
        Vehicle.Mileage mileage = vehicle.getMileage();

        return new VehicleResponse(
                vehicle.getVin(),
                make != null ? make.getId() : null,
                make != null ? make.getName() : null,
                model != null ? model.getId() : null,
                model != null ? model.getName() : null,
                trim != null ? trim.getId() : null,
                trim != null ? trim.getYear() : null,
                trim != null ? trim.getName() : null,
                trim != null ? trim.getDescription() : null,
                trim != null ? trim.getMsrp() : null,
                trim != null ? trim.getInvoice() : null,
                engine != null ? engine.getId() : null,
                engine != null ? engine.getType() : null,
                engine != null ? engine.getFuelType() : null,
                engine != null ? engine.getCylinders() : null,
                engine != null ? engine.getSize() : null,
                engine != null ? engine.getHorsepowerHp() : null,
                engine != null ? engine.getHorsepowerRpm() : null,
                engine != null ? engine.getTorqueFtLbs() : null,
                engine != null ? engine.getTorqueRpm() : null,
                engine != null ? engine.getValves() : null,
                engine != null ? engine.getValveTiming() : null,
                engine != null ? engine.getCamType() : null,
                engine != null ? engine.getDriveType() : null,
                engine != null ? engine.getTransmission() : null,
                body != null ? body.getId() : null,
                body != null ? body.getType() : null,
                body != null ? body.getDoors() : null,
                body != null ? body.getSeats() : null,
                body != null ? body.getLength() : null,
                body != null ? body.getWidth() : null,
                body != null ? body.getHeight() : null,
                body != null ? body.getWheelBase() : null,
                body != null ? body.getFrontTrack() : null,
                body != null ? body.getRearTrack() : null,
                body != null ? body.getGroundClearance() : null,
                body != null ? body.getCargoCapacity() : null,
                body != null ? body.getMaxCargoCapacity() : null,
                body != null ? body.getCurbWeight() : null,
                body != null ? body.getGrossWeight() : null,
                body != null ? body.getMaxPayload() : null,
                body != null ? body.getMaxTowingCapacity() : null,
                mileage != null ? mileage.getId() : null,
                mileage != null ? mileage.getFuelTankCapacity() : null,
                mileage != null ? mileage.getCombinedMpg() : null,
                mileage != null ? mileage.getEpaCityMpg() : null,
                mileage != null ? mileage.getEpaHighwayMpg() : null,
                mileage != null ? mileage.getRangeCity() : null,
                mileage != null ? mileage.getRangeHighway() : null
        );
    }
}
