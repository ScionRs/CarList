package ru.ravilov.ClientBase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ravilov.ClientBase.model.ModificationsTruck;
import ru.ravilov.ClientBase.model.MotorcycleCategory;
import ru.ravilov.ClientBase.repository.ModificationsTruckRepository;
import ru.ravilov.ClientBase.repository.MotoCategoryRepository;

import java.util.List;

@Service
public class ModificationsTruckService {

    private ModificationsTruckRepository  modificationsTruckRepository;
    @Autowired
    public ModificationsTruckService(ModificationsTruckRepository modificationsTruckRepository) {
        this.modificationsTruckRepository = modificationsTruckRepository;
    }

    public List<ModificationsTruck> listAll(){
        return  modificationsTruckRepository.findAll();
    }

    public ModificationsTruck save(ModificationsTruck modificationsTruck){
        return modificationsTruckRepository.save(modificationsTruck);
    }

    public ModificationsTruck get(Long id){
        return modificationsTruckRepository.findById(id).get();
    }

    public void delete(Long id){
        modificationsTruckRepository.deleteById(id);
    }
}
