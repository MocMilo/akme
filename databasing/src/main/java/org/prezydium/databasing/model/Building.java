package org.prezydium.databasing.model;


import javax.persistence.*;

@Entity
@Table(name = "BUILDINGS")
public class Building {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "BUILDING_TYPE")
    @Enumerated(EnumType.STRING)
    private BuildingType buildingType;

    @Column(name = "ADDRESS")
    @ManyToOne
    private Address address;

    public Building() {
    }

    public Building(BuildingType buildingType, Address address) {
        this.buildingType = buildingType;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BuildingType getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(BuildingType buildingType) {
        this.buildingType = buildingType;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


}
