package ru.ravilov.ClientBase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ravilov.ClientBase.model.Truck;
import ru.ravilov.ClientBase.repository.TruckRepository;

import java.util.List;

@Service
public class TruckService {

    private TruckRepository truckRepository;
    @Autowired
    public TruckService(TruckRepository truckRepository) {
        this.truckRepository = truckRepository;
    }

    public List<Truck> listAll(){
        return  truckRepository.findAll();
    }

    public Truck save(Truck truck){
            return truckRepository.save(truck);
    }

    public Truck get(Long id){
        return truckRepository.findById(id).get();
    }

    public void delete(Long id){
         truckRepository.deleteById(id);
    }
}
