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
    private String buildCountry;
    private int price;
    private String typeOfFuel;
    private String maxSpeed;
    private String fuelCycle;
    private String powerReserve;
    private String length;
    private String width;
    private String height;
    private String curbWeight;
    private String engineType;
    private String numberOfCyclindersAndArrangement;
    private int numberOfMeasures;
    private int numberOfValvesCyclinder;
    private String coolingSystem;
    private String launchSystem;
    private int enginePower;
    private String engineDisplacement;
    private String torque;
    private String transmissionType;
    private String electronicControlSystems;
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
