package org.prezydium.databasing.generator;


import org.prezydium.databasing.model.Building;
import org.prezydium.databasing.model.BuildingType;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomBuildingGenerator {

    private final RandomAddressGenerator randomAddressGenerator;

    public RandomBuildingGenerator(RandomAddressGenerator randomAddressGenerator) {
        this.randomAddressGenerator = randomAddressGenerator;
    }

    public Building generateRandomBuilding() {
        Building building = new Building();
        building.setBuildingType(randomBuildingType());
        building.setAddress(randomAddressGenerator.generateRandomAddress());
        return building;
    }

    private BuildingType randomBuildingType() {
        int buildingTypeRandomBoundary = BuildingType.values().length;
        int randomValueOfBuildingType = new Random().nextInt(buildingTypeRandomBoundary);
        return BuildingType.values()[randomValueOfBuildingType];
    }
}
