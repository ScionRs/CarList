package ru.ravilov.ClientBase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ravilov.ClientBase.model.CarCategory;
import ru.ravilov.ClientBase.repository.CarCategoryRepository;

import java.util.List;

@Service
public class CarCategoryService {

    @Autowired
    CarCategoryRepository carCategoryRepository;

    public List<CarCategory> listAll(){ return  carCategoryRepository.findAll();}

    public CarCategory save(CarCategory category){return  carCategoryRepository.save(category);}

    public CarCategory get(Integer id) { return carCategoryRepository.findById(id).get();}

    public void delete(Integer id){ carCategoryRepository.deleteById(id);
    }

}
