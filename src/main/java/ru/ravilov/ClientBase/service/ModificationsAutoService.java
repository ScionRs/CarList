package ru.ravilov.ClientBase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ravilov.ClientBase.model.ModificationAuto;
import ru.ravilov.ClientBase.repository.ModificationsAutoRepository;

import java.util.List;

@Service
public class ModificationsAutoService {
    private ModificationsAutoRepository modificationsAutoRepository;
    @Autowired
    public ModificationsAutoService(ModificationsAutoRepository modificationsAutoRepository) {
        this.modificationsAutoRepository = modificationsAutoRepository;
    }

    public List<ModificationAuto> listAll(){
        return  modificationsAutoRepository.findAll();
    }

    public ModificationAuto save(ModificationAuto modificationsTruck){
        return modificationsAutoRepository.save(modificationsTruck);
    }

    public ModificationAuto get(Long id){
        return modificationsAutoRepository.findById(id).get();
    }

    public void delete(Long id){
        modificationsAutoRepository.deleteById(id);
    }
}
