package ru.ravilov.ClientBase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
public class ModificationAuto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String brand;

    private String model;

    private String modification;

    private int year;

    private String bodyType;

    private String numberOfDoors;

    private String numberOfSeats;

    private String buildCountry;

    private String guarantee;

    private int price;

    private String typeOfFuel;

    private String accelerationTime;

    private String maxSpeed;

    private double fuelUrbanCycle;

    private double fuelHigwayCycle;

    private double fuelMixedCycle;

    private String powerReserve;

    private String length;

    private String width;

    private String height;

    private String curbWeight;

    private String fullMass;

    private String carryingCapacity;

    private String trunkVolume;

    private String fuelTankVolume;

    private String engineType;

    private String numberOfCyclindersAndArrangement;

    private int enginePower;

    private int horsePowerPrice;

    private String engineDisplacement;

    private String torque;

    private String driveUnit;

    private String transmissionType;

    private String powerSteering;

    private String electronicControlSystems;

    private String climateControl;

    private String frontSuspension;

    private String rearSuspension;

    private String frontBrakes;

    private String rearBrakes;

    private String tireSize;

    private String diskSize;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")
    private Car cars;


}
