package ru.ravilov.ClientBase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Brand;

    private String model;

    private String BodyType;

    private int year;

    private String transmission;

    private int price;

    private String description;

    private String image;

    private String image2;

    private String image3;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private CarCategory carCategory;

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
