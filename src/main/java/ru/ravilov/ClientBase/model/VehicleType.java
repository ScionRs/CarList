package ru.ravilov.ClientBase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VehicleType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id",nullable = false)
    private Long id;
    @Column(name ="name",nullable = false)
    private String name;
    @Column(name = "image",nullable = false)
    private String image;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "vehicle_type")
    private List<CarCategory> carCategoryList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "vehicle_type")
    private List<MotorcycleCategory> motorcycleCategoryList;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "vehicle_type")
    private List<TruckCategory> truckCategoryList;

    @Transient
    public String getLogoImagePath(){
        if(image == null || id == null)
            return  null;
        return  "/brand-logos/" + id + "/" + image;
    }
}
