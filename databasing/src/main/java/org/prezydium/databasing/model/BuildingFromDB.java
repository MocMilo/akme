package org.prezydium.databasing.model;

public class BuildingFromDB {

    private BuildingType buildingType;
    private String city;
    private String street;
    private String buildingNumber;

    public BuildingFromDB() {
    }

    public BuildingFromDB(BuildingType buildingType, String city, String street, String buildingNumber) {
        this.buildingType = buildingType;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
    }

    public BuildingType getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(BuildingType buildingType) {
        this.buildingType = buildingType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }
}
