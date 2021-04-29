package ru.ravilov.ClientBase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ravilov.ClientBase.model.Motorcycle;
import ru.ravilov.ClientBase.model.Truck;
import ru.ravilov.ClientBase.model.TruckCategory;
import ru.ravilov.ClientBase.repository.MotoRepository;
import ru.ravilov.ClientBase.repository.TruckCategoryRepository;
import ru.ravilov.ClientBase.repository.TruckRepository;

import java.util.List;

@Service
public class TruckCategoryService {

    private TruckCategoryRepository truckRepository;
    @Autowired
    public TruckCategoryService(TruckCategoryRepository truckRepository) {
        this.truckRepository = truckRepository;
    }

    public List<TruckCategory> listAll(){
        return  truckRepository.findAll();
    }

    public TruckCategory save(TruckCategory truckCategory){
        return truckRepository.save(truckCategory);
    }

    public TruckCategory get(Long id){
        return truckRepository.findById(id).get();
    }

    public void delete(Long id){
        truckRepository.deleteById(id);
    }
}
