package ru.ravilov.ClientBase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity(name = "motorcycle")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Motorcycle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id",nullable = false)
    private Long id;
    @Column(name ="brand",nullable = false)
    private String brand;
    @Column(name ="model",nullable = false)
    private String model;
    @Column(name ="year",nullable = false)
    private int year;
    @Column(name ="transmission",nullable = false)
    private String transmission;
    @Column(name ="price",nullable = false)
    private int price;
    @Column(name ="description",nullable = false)
    private String description;
    @Column(name = "image",nullable = false)
    private String image;
    @Column(name = "image2",nullable = false)
    private String image2;
    @Column(name = "image3",nullable = false)
    private String image3;



    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "moto_category_id")
    private MotorcycleCategory motoCategory;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "moto")
    private List<ModificationMoto> modificationMotos;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "motoList")
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
