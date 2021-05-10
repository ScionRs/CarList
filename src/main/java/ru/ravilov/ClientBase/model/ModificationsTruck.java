package ru.ravilov.ClientBase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ModificationsTruck {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id",nullable = false)
    private Long id;
    @Column(name ="brand",nullable = false)
    private String brand;
    @Column(name ="model",nullable = false)
    private String model;
    @Column(name="modification",nullable = false)
    private String modification;
    @Column(name="year",nullable = false)
    private int year;
    @Column(name="bodyType",nullable = false)
    private String bodyType;
    @Column(name="number_of_doors",nullable = false)
    private String numberOfDoors;
    @Column(name="number_of_seats",nullable = false)
    private String numberOfSeats;
    @Column(name="build_country",nullable = false)
    private String buildCountry;
    @Column(name="guarantee",nullable = false)
    private String guarantee;
    @Column(name="price",nullable = false)
    private int price;
    @Column(name="type_of_fuel",nullable = false)
    private String typeOfFuel;
    @Column(name="acceleration_time",nullable = false)
    private String accelerationTime;
    @Column(name="maxspeed",nullable = false)
    private String maxSpeed;
    @Column(name="fuel_urban_cycle",nullable = false)
    private String fuelUrbanCycle;
    @Column(name="fuel_higway_cycle",nullable = false)
    private String fuelHigwayCycle;
    @Column(name="fuel_mixed_cycle",nullable = false)
    private String fuelMixedCycle;
    @Column(name="power_reserve",nullable = false)
    private String powerReserve;
    @Column(name="length",nullable = false)
    private String length;
    @Column(name="width",nullable = false)
    private String width;
    @Column(name="height",nullable = false)
    private String height;
    @Column(name="curb_weight",nullable = false)
    private String curbWeight;
    @Column(name="full_mass",nullable = false)
    private int fullMass;
    @Column(name="carrying_capacity",nullable = false)
    private int carryingCapacity;
    @Column(name="trunk_volume",nullable = false)
    private int trunkVolume;
    @Column(name="fuel_tank_volume",nullable = false)
    private int fuelTankVolume;
    @Column(name="engine_type",nullable = false)
    private String engineType;
    @Column(name="number_of_cyclinders_and_arrangement",nullable = false)
    private String numberOfCyclindersAndArrangement;
    @Column(name="engine_power",nullable = false)
    private String enginePower;
    @Column(name="engine_displacement",nullable = false)
    private String engineDisplacement;
    @Column(name="torque",nullable = false)
    private String torque;
    @Column(name="drive_unit",nullable = false)
    private String driveUnit;
    @Column(name="transmission_type",nullable = false)
    private String transmissionType;
    @Column(name="power_steering",nullable = false)
    private String powerSteering;
    @Column(name="electronic_control_systems",nullable = false)
    private String electronicControlSystems;
    @Column(name="climate_control",nullable = false)
    private String climateControl;
    @Column(name="front_suspension",nullable = false)
    private String frontSuspension;
    @Column(name="rear_suspension",nullable = false)
    private String rearSuspension;
    @Column(name="front_brakes",nullable = false)
    private String frontBrakes;
    @Column(name="rear_brakes",nullable = false)
    private String rearBrakes;
    @Column(name="tire_size",nullable = false)
    private String tireSize;
    @Column(name="disk_size",nullable = false)
    private String diskSize;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "truck_id")
    private Truck truck;
}
