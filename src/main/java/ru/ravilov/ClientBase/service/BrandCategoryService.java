package ru.ravilov.ClientBase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ravilov.ClientBase.model.BrandCategory;
import ru.ravilov.ClientBase.repository.BrandCategoryRepository;

import java.util.List;

@Service
public class BrandCategoryService {

    @Autowired
    BrandCategoryRepository brandCategoryRepository;

    public List<BrandCategory> listAll(){ return  brandCategoryRepository.findAll();}

    public BrandCategory save(BrandCategory category){return  brandCategoryRepository.save(category);}

    public BrandCategory get(Integer id) { return brandCategoryRepository.findById(id).get();}

    public void delete(Integer id){ brandCategoryRepository.deleteById(id);
    }

}
