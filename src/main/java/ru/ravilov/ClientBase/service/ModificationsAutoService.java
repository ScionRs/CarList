package ru.ravilov.ClientBase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ravilov.ClientBase.model.Cost;
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

    public ModificationAuto save(ModificationAuto modificationAuto) {
        return modificationsAutoRepository.save(modificationAuto);
    }

    public ModificationAuto get(Long id){
        return modificationsAutoRepository.findById(id).get();
    }

    public void delete(Long id){
        modificationsAutoRepository.deleteById(id);
    }


   /* ModificationAuto modificationAuto = new ModificationAuto();
    public ModificationAuto horsepowerCalculating(int price){
        if (modificationAuto.getEnginePower() < 100){
            price = 12 * modificationAuto.getEnginePower();
            modificationAuto.setHorsePowerPrice(price);
            return modificationsAutoRepository.save(modificationAuto);
        } else if (modificationAuto.getEnginePower() > 100 && modificationAuto.getEnginePower() < 125){
            price = 25 * modificationAuto.getEnginePower();
            modificationAuto.setHorsePowerPrice(price);
            return modificationsAutoRepository.save(modificationAuto);
        } else if (modificationAuto.getEnginePower() > 125 && modificationAuto.getEnginePower() < 150){
            price = 35 * modificationAuto.getEnginePower();
            modificationAuto.setHorsePowerPrice(price);
            return modificationsAutoRepository.save(modificationAuto);
        } else if(modificationAuto.getEnginePower() > 150 && modificationAuto.getEnginePower() < 175){
            price = 45 * modificationAuto.getEnginePower();
            modificationAuto.setHorsePowerPrice(price);
            return modificationsAutoRepository.save(modificationAuto);
        } else if(modificationAuto.getEnginePower() > 175 && modificationAuto.getEnginePower() < 200){
            price = 50 * modificationAuto.getEnginePower();
            modificationAuto.setHorsePowerPrice(price);
            return modificationsAutoRepository.save(modificationAuto);
        } else if (modificationAuto.getEnginePower() > 200 && modificationAuto.getEnginePower() < 225){
            price = 65 * modificationAuto.getEnginePower();
            modificationAuto.setHorsePowerPrice(price);
            return modificationsAutoRepository.save(modificationAuto);
        } else if (modificationAuto.getEnginePower() > 225 && modificationAuto.getEnginePower() < 250){
            price = 75 * modificationAuto.getEnginePower();
            modificationAuto.setHorsePowerPrice(price);
            return modificationsAutoRepository.save(modificationAuto);
        } else if (modificationAuto.getEnginePower() > 250){
            price = 150 * modificationAuto.getEnginePower();
            modificationAuto.setHorsePowerPrice(price);
            return modificationsAutoRepository.save(modificationAuto);
        } else {
            return new ModificationAuto();
        }
    } */

}
