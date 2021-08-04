package ru.ravilov.ClientBase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;

    private String model;

    private String bodyType;

    private int year;

    private String transmission;

    private int price;

    private String country;

    private String description;

    private String image;

    private String image2;

    private String image3;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "car_category_id")
    private CarCategory carCategory;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "segment_id")
    private Segment segment;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "cars")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<ModificationAuto> modificationAuto;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "carList")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Generation> generations;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "cars")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Cost> costs;

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
