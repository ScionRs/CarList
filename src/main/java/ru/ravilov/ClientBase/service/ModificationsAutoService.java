package ru.ravilov.ClientBase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        horsePowerCalc(modificationAuto);
        combinedFuelCosts(modificationAuto);
        repairCost(modificationAuto);
        totalExpense(modificationAuto);
        return modificationsAutoRepository.save(modificationAuto);
    }

    public ModificationAuto get(Long id){
        return modificationsAutoRepository.findById(id).get();
    }

    public void delete(Long id){
        modificationsAutoRepository.deleteById(id);
    }

    public void horsePowerCalc(ModificationAuto modificationAuto){
        int price = 0;
        if (modificationAuto.getEnginePower() != 0 && modificationAuto.getEnginePower() > 0) {
            if (modificationAuto.getEnginePower() < 100) {
                price = 12 * modificationAuto.getEnginePower();
                modificationAuto.setHorsePowerPrice(price);
            } else if (modificationAuto.getEnginePower() > 100 && modificationAuto.getEnginePower() < 125) {
                price = 25 * modificationAuto.getEnginePower();
                modificationAuto.setHorsePowerPrice(price);
            } else if (modificationAuto.getEnginePower() > 125 && modificationAuto.getEnginePower() < 150) {
                price = 35 * modificationAuto.getEnginePower();
                modificationAuto.setHorsePowerPrice(price);
            } else if (modificationAuto.getEnginePower() > 150 && modificationAuto.getEnginePower() < 175) {
                price = 45 * modificationAuto.getEnginePower();
                modificationAuto.setHorsePowerPrice(price);
            } else if (modificationAuto.getEnginePower() > 175 && modificationAuto.getEnginePower() < 200) {
                price = 50 * modificationAuto.getEnginePower();
                modificationAuto.setHorsePowerPrice(price);
            } else if (modificationAuto.getEnginePower() > 200 && modificationAuto.getEnginePower() < 225) {
                price = 65 * modificationAuto.getEnginePower();
                modificationAuto.setHorsePowerPrice(price);
            } else if (modificationAuto.getEnginePower() > 225 && modificationAuto.getEnginePower() < 250) {
                price = 75 * modificationAuto.getEnginePower();
                modificationAuto.setHorsePowerPrice(price);
            } else if (modificationAuto.getEnginePower() > 250) {
                price = 150 * modificationAuto.getEnginePower();
                modificationAuto.setHorsePowerPrice(price);
            }
        } else {
            price = 12 * modificationAuto.getEnginePower() ;
            modificationAuto.setHorsePowerPrice(price);
        }
    }
    //цена 100км в различных режимах
    public void combinedFuelCosts(ModificationAuto modificationAuto){
        double priceCity = 0,priceHigway = 0,priceCombined = 0,
                priceCombinedMonth = 0,priceCombinedYear = 0;
        if (modificationAuto.getTypeOfFuel().toLowerCase().equals("аи-95")) {
            priceCity = (int) (modificationAuto.getFuelUrbanCycle() * 48.25);
            priceHigway = (int) (modificationAuto.getFuelHigwayCycle() * 48.25);
            priceCombined = (int) (modificationAuto.getFuelMixedCycle() * 48.25);
            priceCombinedMonth = priceCombined * 15;
            priceCombinedYear = priceCombinedMonth * 12;
            modificationAuto.setFuelMixedCyclePriceMonth(priceCombinedMonth);
            modificationAuto.setFuelMixedCyclePriceYear(priceCombinedYear);
            modificationAuto.setFuelUrbanCyclePrice(priceCity);
            modificationAuto.setFuelHigwayCyclePrice(priceHigway);
            modificationAuto.setFuelMixedCyclePrice(priceCombined);
        } else if(modificationAuto.getTypeOfFuel().toLowerCase().equals("аи-92")){
            priceCity = (int) (modificationAuto.getFuelUrbanCycle() * 44.70);
            priceHigway = (int) (modificationAuto.getFuelHigwayCycle() * 44.70);
            priceCombined = (int) (modificationAuto.getFuelMixedCycle() * 44.70);
            priceCombinedMonth = priceCombined * 15;
            priceCombinedYear = priceCombinedMonth * 12;
            modificationAuto.setFuelMixedCyclePriceMonth(priceCombinedMonth);
            modificationAuto.setFuelMixedCyclePriceYear(priceCombinedYear);
            modificationAuto.setFuelUrbanCyclePrice(priceCity);
            modificationAuto.setFuelHigwayCyclePrice(priceHigway);
            modificationAuto.setFuelMixedCyclePrice(priceCombined);
        } else if (modificationAuto.getTypeOfFuel().toLowerCase().equals("аи-98")){
            priceCity = (int) (modificationAuto.getFuelUrbanCycle() * 55.99);
            priceHigway = (int) (modificationAuto.getFuelHigwayCycle() * 55.99);
            priceCombined = (int) (modificationAuto.getFuelMixedCycle() * 55.99);
            priceCombinedMonth = priceCombined * 15;
            priceCombinedYear = priceCombinedMonth * 12;
            modificationAuto.setFuelMixedCyclePriceMonth(priceCombinedMonth);
            modificationAuto.setFuelMixedCyclePriceYear(priceCombinedYear);
            modificationAuto.setFuelUrbanCyclePrice(priceCity);
            modificationAuto.setFuelHigwayCyclePrice(priceHigway);
            modificationAuto.setFuelMixedCyclePrice(priceCombined);
        } else if (modificationAuto.getTypeOfFuel().toLowerCase().equals("дт")){
            priceCity = (int) (modificationAuto.getFuelUrbanCycle() * 48.60);
            priceHigway = (int) (modificationAuto.getFuelHigwayCycle() * 48.60);
            priceCombined = (int) (modificationAuto.getFuelMixedCycle() * 48.60);
            priceCombinedMonth = priceCombined * 15;
            priceCombinedYear = priceCombinedMonth * 12;
            modificationAuto.setFuelMixedCyclePriceMonth(priceCombinedMonth);
            modificationAuto.setFuelMixedCyclePriceYear(priceCombinedYear);
            modificationAuto.setFuelUrbanCyclePrice(priceCity);
            modificationAuto.setFuelHigwayCyclePrice(priceHigway);
            modificationAuto.setFuelMixedCyclePrice(priceCombined);
        }
    }
    // стоимость обслуживания в год в зависимости от цены автомобиля
    public void repairCost(ModificationAuto modificationAuto){
        int price;
        if (modificationAuto.getPrice() > 3_000_000){
            price = (modificationAuto.getPrice() * 5) / 100;
            modificationAuto.setCostsPerYear(price);
        }else if(modificationAuto.getPrice() > 4_000_000){
            price = (modificationAuto.getPrice() * 6) / 100;
            modificationAuto.setCostsPerYear(price);
        } else if(modificationAuto.getPrice() > 5_000_000){
            price = (modificationAuto.getPrice() * 7) / 100;
            modificationAuto.setCostsPerYear(price);
        } else if (modificationAuto.getPrice() > 2_000_000 && modificationAuto.getPrice() < 3_000_000){
            price = (modificationAuto.getPrice() * 4) / 100;
            modificationAuto.setCostsPerYear(price);
        } else if (modificationAuto.getPrice() < 2_000_000){
            price = (modificationAuto.getPrice() * 3) / 100;
            modificationAuto.setCostsPerYear(price);
        }
    }
    // общая сумма расходов за год
    public void totalExpense(ModificationAuto modificationAuto){
        int price = 0;
        price = (int) (modificationAuto.getCostsPerYear() + modificationAuto.getFuelMixedCyclePriceYear() + modificationAuto.getHorsePowerPrice());
        modificationAuto.setTotalSumOfYear(price);
    }

   

}
