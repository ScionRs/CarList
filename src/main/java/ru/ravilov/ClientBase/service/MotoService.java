package ru.ravilov.ClientBase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ravilov.ClientBase.model.Motorcycle;
import ru.ravilov.ClientBase.model.Truck;
import ru.ravilov.ClientBase.repository.MotoRepository;
import ru.ravilov.ClientBase.repository.TruckRepository;

import java.util.List;

@Service
public class MotoService {

    private MotoRepository motoRepository;
    @Autowired
    public MotoService(MotoRepository motoRepository) {
        this.motoRepository = motoRepository;
    }

    public List<Motorcycle> listAll(){
        return  motoRepository.findAll();
    }

    public Motorcycle save(Motorcycle motorcycle){
        return motoRepository.save(motorcycle);
    }

    public Motorcycle get(Long id){
        return motoRepository.findById(id).get();
    }

    public void delete(Long id){
        motoRepository.deleteById(id);
    }
}
