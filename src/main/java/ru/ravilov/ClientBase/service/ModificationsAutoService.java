package ru.ravilov.ClientBase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ravilov.ClientBase.model.ModificationsAuto;
import ru.ravilov.ClientBase.model.ModificationsTruck;
import ru.ravilov.ClientBase.repository.ModificationsAutoRepository;
import ru.ravilov.ClientBase.repository.ModificationsTruckRepository;

import java.util.List;

@Service
public class ModificationsAutoService {
    private ModificationsAutoRepository modificationsAutoRepository;
    @Autowired
    public ModificationsAutoService(ModificationsAutoRepository modificationsAutoRepository) {
        this.modificationsAutoRepository = modificationsAutoRepository;
    }

    public List<ModificationsAuto> listAll(){
        return  modificationsAutoRepository.findAll();
    }

    public ModificationsAuto save(ModificationsAuto modificationsTruck){
        return modificationsAutoRepository.save(modificationsTruck);
    }

    public ModificationsAuto get(Long id){
        return modificationsAutoRepository.findById(id).get();
    }

    public void delete(Long id){
        modificationsAutoRepository.deleteById(id);
    }
}
