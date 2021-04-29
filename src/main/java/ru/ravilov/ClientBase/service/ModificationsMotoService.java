package ru.ravilov.ClientBase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ravilov.ClientBase.model.ModificationsMoto;
import ru.ravilov.ClientBase.model.ModificationsTruck;
import ru.ravilov.ClientBase.repository.ModificationsMotoRepository;
import ru.ravilov.ClientBase.repository.ModificationsTruckRepository;

import java.util.List;

@Service
public class ModificationsMotoService {

    private ModificationsMotoRepository modificationsMotoRepository;
    @Autowired
    public ModificationsMotoService(ModificationsMotoRepository modificationsMotoRepository) {
        this.modificationsMotoRepository = modificationsMotoRepository;
    }

    public List<ModificationsMoto> listAll(){
        return  modificationsMotoRepository.findAll();
    }

    public ModificationsMoto save(ModificationsMoto modificationsMoto){
        return modificationsMotoRepository.save(modificationsMoto);
    }

    public ModificationsMoto get(Long id){
        return modificationsMotoRepository.findById(id).get();
    }

    public void delete(Long id){
        modificationsMotoRepository.deleteById(id);
    }
}
