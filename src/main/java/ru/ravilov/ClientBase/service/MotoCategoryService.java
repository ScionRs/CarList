package ru.ravilov.ClientBase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ravilov.ClientBase.model.MotorcycleCategory;
import ru.ravilov.ClientBase.model.TruckCategory;
import ru.ravilov.ClientBase.repository.MotoCategoryRepository;
import ru.ravilov.ClientBase.repository.TruckCategoryRepository;

import java.util.List;

@Service
public class MotoCategoryService {

    private MotoCategoryRepository motoCategoryRepository;
    @Autowired
    public MotoCategoryService(MotoCategoryRepository motoCategoryRepository) {
        this.motoCategoryRepository = motoCategoryRepository;
    }

    public List<MotorcycleCategory> listAll(){
        return  motoCategoryRepository.findAll();
    }

    public MotorcycleCategory save(MotorcycleCategory motorcycleCategory){
        return motoCategoryRepository.save(motorcycleCategory);
    }

    public MotorcycleCategory get(Long id){
        return motoCategoryRepository.findById(id).get();
    }

    public void delete(Long id){
        motoCategoryRepository.deleteById(id);
    }
}
