package ru.ravilov.ClientBase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "modification_moto")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ModificationsMoto {
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
    @Column(name="seat_height",nullable = false)
    private String seatHeight;
    @Column(name="curb_weight",nullable = false)
    private String curbWeight;
    @Column(name="trunk_volume",nullable = false)
    private int trunkVolume;
    @Column(name="engine_type",nullable = false)
    private String engineType;
    @Column(name="number_of_cyclinders_and_arrangement",nullable = false)
    private String numberOfCyclindersAndArrangement;
    @Column(name="number_of_measures",nullable = false)
    private int numberOfMeasures;
    @Column(name="number_of_valves_cylinder",nullable = false)
    private int numberOfValvesCyclinder;
    @Column(name="cooling_system",nullable = false)
    private String coolingSystem;
    @Column(name="launch_system",nullable = false)
    private String launchSystem;
    @Column(name="engine_power",nullable = false)
    private String enginePower;
    @Column(name="engine_displacement",nullable = false)
    private String engineDisplacement;
    @Column(name="torque",nullable = false)
    private String torque;
    @Column(name="number_of_gears",nullable = false)
    private int numberOfGears;
    @Column(name="main_gear",nullable = false)
    private int mainGear;
    @Column(name="transmission_type",nullable = false)
    private int transmissionType;
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
}
