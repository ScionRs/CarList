package ru.ravilov.ClientBase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Truck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;

    private String model;

    private String BodyType;

    private int year;

    private String transmission;

    private int price;

    private String description;

    private String country;

    private String image;

    private String image2;

    private String image3;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "truck_id")
    private TruckCategory truckCategory;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "truck")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<ModificationTruck> modificationTrucks;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "truckList")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Generation> generations;

    @Transient
    public String getLogoImagePath(){
        if(image == null || id == null)
            return  null;
        return  "/brand-logos/" + id + "/" + image;
    }

    @Transient
    public String getLogoImagePath2(){
        if(image2 == null || id == null)
            return  null;
        return  "/brand-logos/" + id + "/" + image2;
    }

    @Transient
    public String getLogoImagePath3(){
        if(image3 == null || id == null)
            return  null;
        return  "/brand-logos/" + id + "/" + image3;
    }
}
