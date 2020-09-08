package ru.ravilov.ClientBase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.ravilov.ClientBase.model.Brand;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand,Integer> {
    @Query("SELECT p FROM Brand p WHERE CONCAT(p.Brand, ' ', p.model, ' ', p.BodyType, ' ', p.year, ' ',p.transmission, ' ',p.price) LIKE %?1%")
    public List<Brand> search(String keyword);
}
