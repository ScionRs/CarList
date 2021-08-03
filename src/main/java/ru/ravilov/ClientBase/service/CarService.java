package ru.ravilov.ClientBase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ravilov.ClientBase.model.Car;
import ru.ravilov.ClientBase.repository.CarRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> listAll() {
        return carRepository.findAll();
    }

    public List<Car> listAll(String keyword){
        if(keyword != null){
            return carRepository.search(keyword);
        }
        return carRepository.findAll();
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public Car get(Long id) {
        return carRepository.findById(id).get();
    }

    public void delete(Long id){
        carRepository.deleteById(id);
    }

}
