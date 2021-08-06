package ru.ravilov.ClientBase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ravilov.ClientBase.model.Generation;
import ru.ravilov.ClientBase.model.ModificationAuto;
import ru.ravilov.ClientBase.repository.GenerationRepository;

import java.util.List;

@Service
public class GenerationService {

    private GenerationRepository generationRepository;
    @Autowired
    public GenerationService(GenerationRepository generationRepository) {
        this.generationRepository = generationRepository;
    }

    public List<Generation> listAll(){
        return  generationRepository.findAll();
    }

    public Generation save(Generation generation){
        return generationRepository.save(generation);
    }

    public Generation get(Long id){
        return generationRepository.findById(id).get();
    }

    public void delete(Long id){
        generationRepository.deleteById(id);
    }

}
