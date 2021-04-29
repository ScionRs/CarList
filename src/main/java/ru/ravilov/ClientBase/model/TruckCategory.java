package ru.ravilov.ClientBase.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TruckCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String country;

    private String image;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "vehicle_type_id")
    private VehicleType vehicleType;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER,mappedBy = "truckCategory")
    private List<Truck> truckList;



    @Transient
    public String getLogoImagePath(){
        if(image == null || id == null)
            return  null;
        return  "/brand-logos/" + id + "/" + image;

    }
}
