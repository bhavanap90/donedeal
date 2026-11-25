package com.vehicle.inventory_service.dto;

public record VehicleQuickResponse(
        String makeName,
        String modelName,
        int trimYear,
        String bodyType
) {
    public VehicleQuickResponse(String makeName, String modelName, int trimYear, String bodyType) {
        this.makeName = makeName;
        this.modelName = modelName;
        this.trimYear = trimYear;
        this.bodyType = bodyType;
    }
}
