package ru.ravilov.ClientBase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ravilov.ClientBase.model.Truck;
import ru.ravilov.ClientBase.model.VehicleType;
import ru.ravilov.ClientBase.repository.TruckRepository;
import ru.ravilov.ClientBase.repository.VehicleTypeRepository;

import java.util.List;

@Service
public class VehicleTypeService {

    private VehicleTypeRepository vehicleTypeRepository;
    @Autowired
    public VehicleTypeService(VehicleTypeRepository vehicleTypeRepository) {
        this.vehicleTypeRepository = vehicleTypeRepository;
    }

    public List<VehicleType> listAll(){
        return  vehicleTypeRepository.findAll();
    }

    public VehicleType save(VehicleType vehicleType){
        return vehicleTypeRepository.save(vehicleType);
    }

    public VehicleType get(Long id){
        return vehicleTypeRepository.findById(id).get();
    }

    public void delete(Long id){
        vehicleTypeRepository.deleteById(id);
    }
}
