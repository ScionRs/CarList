package ru.ravilov.ClientBase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ravilov.ClientBase.model.Car;
import ru.ravilov.ClientBase.model.Cost;
import ru.ravilov.ClientBase.model.ModificationAuto;
import ru.ravilov.ClientBase.repository.CostRepository;

import java.util.List;

@Service
public class CostService {

    private CostRepository costRepository;
    private ModificationAuto modificationAuto = new ModificationAuto();

    @Autowired
    public CostService(CostRepository costRepository) {
        this.costRepository = costRepository;
    }

    public List<Cost> listAll() {
        return costRepository.findAll();
    }

    public Cost save(Cost cost) {
        calculateHorsePowerMethod(cost,modificationAuto);

        return costRepository.save(cost);
    }

    public Cost get(Long id) {
        return costRepository.findById(id).get();
    }

    public void delete(Long id){
        costRepository.deleteById(id);
    }

    public void calculateHorsePowerMethod(Cost cost, ModificationAuto modificationAuto){
        if (modificationAuto.getEnginePower() < 100){
            cost.setHorsepowerPrice(12 * modificationAuto.getEnginePower());
        }  else if (modificationAuto.getEnginePower() > 100 && modificationAuto.getEnginePower() < 125){
            cost.setHorsepowerPrice(25 * modificationAuto.getEnginePower());
        } else if (modificationAuto.getEnginePower() > 125 && modificationAuto.getEnginePower() < 150){
            cost.setHorsepowerPrice(35 * modificationAuto.getEnginePower());
        } else if(modificationAuto.getEnginePower() > 150 && modificationAuto.getEnginePower() < 175){
            cost.setHorsepowerPrice(45 * modificationAuto.getEnginePower());
        } else if(modificationAuto.getEnginePower() > 175 && modificationAuto.getEnginePower() < 200){
            cost.setHorsepowerPrice(50 * modificationAuto.getEnginePower());
        } else if (modificationAuto.getEnginePower() > 200 && modificationAuto.getEnginePower() < 225){
            cost.setHorsepowerPrice(65 * modificationAuto.getEnginePower());
        } else if (modificationAuto.getEnginePower() > 225 && modificationAuto.getEnginePower() < 250){
            cost.setHorsepowerPrice(75 * modificationAuto.getEnginePower());
        } else if (modificationAuto.getEnginePower() > 250){
            cost.setHorsepowerPrice(150 * modificationAuto.getEnginePower());
        }
    }
}
