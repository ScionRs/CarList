package ru.ravilov.ClientBase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ravilov.ClientBase.model.ModificationMoto;
import ru.ravilov.ClientBase.repository.ModificationsMotoRepository;

import java.util.List;

@Service
public class ModificationsMotoService {

    private ModificationsMotoRepository modificationsMotoRepository;
    @Autowired
    public ModificationsMotoService(ModificationsMotoRepository modificationsMotoRepository) {
        this.modificationsMotoRepository = modificationsMotoRepository;
    }

    public List<ModificationMoto> listAll(){
        return  modificationsMotoRepository.findAll();
    }

    public ModificationMoto save(ModificationMoto modificationMoto){
        return modificationsMotoRepository.save(modificationMoto);
    }

    public ModificationMoto get(Long id){
        return modificationsMotoRepository.findById(id).get();
    }

    public void delete(Long id){
        modificationsMotoRepository.deleteById(id);
    }
}
