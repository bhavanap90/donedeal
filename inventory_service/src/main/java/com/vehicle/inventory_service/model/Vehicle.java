package model;

import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.Data;

import java.time.Instant;

@Data
@Document(value = "vehicle")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vehicle {

    @Id
    private String id;

    @Indexed(unique = true)
    @Field("vin")
    private String vin;

    private Make make;
    private Model model;
    private Trim trim;
    private Engine engine;
    private Body body;
    private Mileage mileage;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Make {
        private Integer id;
        private String name;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Model {
        private Integer id;
        private String name;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Trim {
        private Integer id;
        private Integer year;
        private String name;
        private String description;
        private Double msrp;
        private Double invoice;
        private Instant created;
        private Instant modified;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Engine {
        private Integer id;
        private String type;
        private String fuelType;
        private Integer cylinders;
        private Double size;
        private Integer horsepowerHp;
        private Integer horsepowerRpm;
        private Integer torqueFtLbs;
        private Integer torqueRpm;
        private Integer valves;
        private String valveTiming;
        private String camType;
        private String driveType;
        private String transmission;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Body {
        private Integer id;
        private String type;
        private Integer doors;
        private Integer seats;
        private Double length;
        private Double width;
        private Double height;
        private Double wheelBase;
        private Double frontTrack;
        private Double rearTrack;
        private Double groundClearance;
        private Double cargoCapacity;
        private Double maxCargoCapacity;
        private Integer curbWeight;
        private Integer grossWeight;
        private Integer maxPayload;
        private Integer maxTowingCapacity;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Mileage {
        private Integer id;
        private Double fuelTankCapacity;
        private Integer combinedMpg;
        private Integer epaCityMpg;
        private Integer epaHighwayMpg;
        private Integer rangeCity;
        private Integer rangeHighway;
    }
}