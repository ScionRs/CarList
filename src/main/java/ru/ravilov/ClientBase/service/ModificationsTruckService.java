package ru.ravilov.ClientBase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ravilov.ClientBase.model.ModificationTruck;
import ru.ravilov.ClientBase.repository.ModificationsTruckRepository;

import java.util.List;

@Service
public class ModificationsTruckService {

    private ModificationsTruckRepository  modificationsTruckRepository;
    @Autowired
    public ModificationsTruckService(ModificationsTruckRepository modificationsTruckRepository) {
        this.modificationsTruckRepository = modificationsTruckRepository;
    }

    public List<ModificationTruck> listAll(){
        return  modificationsTruckRepository.findAll();
    }

    public ModificationTruck save(ModificationTruck modificationTruck){
        return modificationsTruckRepository.save(modificationTruck);
    }

    public ModificationTruck get(Long id){
        return modificationsTruckRepository.findById(id).get();
    }

    public void delete(Long id){
        modificationsTruckRepository.deleteById(id);
    }
}
