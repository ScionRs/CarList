package ru.ravilov.ClientBase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ModificationMoto {

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
    private String fuelUrbanCycle;
    private String fuelHigwayCycle;
    private String fuelMixedCycle;
    private String powerReserve;
    private String length;
    private String width;
    private String height;
    private String seatHeight;
    private String curbWeight;
    private int trunkVolume;
    private String engineType;
    private String numberOfCyclindersAndArrangement;
    private int numberOfMeasures;
    private int numberOfValvesCyclinder;
    private String coolingSystem;
    private String launchSystem;
    private String enginePower;
    private String engineDisplacement;
    private String torque;
    private int numberOfGears;
    private int mainGear;
    private int transmissionType;
    private String electronicControlSystems;
    private String climateControl;
    private String frontSuspension;
    private String rearSuspension;
    private String frontBrakes;
    private String rearBrakes;
    private String tireSize;
    private String diskSize;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "moto_id")
    private Motorcycle moto;

}
