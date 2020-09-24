package ru.ravilov.ClientBase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ravilov.ClientBase.model.Brand;
import ru.ravilov.ClientBase.repository.BrandRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {

    @Autowired
    private BrandRepository brandRepository;

    public List<Brand> listAll() {
        return brandRepository.findAll();
    }


    public Brand save(Brand brand) {
        return brandRepository.save(brand);
    }


    public Brand get(Integer id) {
        return brandRepository.findById(id).get();
    }

    public void delete(Integer id){
        brandRepository.deleteById(id);
    }

    public List<Brand> listAll(String keyword){
        if(keyword != null){
            return brandRepository.search(keyword);
        }
        return brandRepository.findAll();
    }
}
