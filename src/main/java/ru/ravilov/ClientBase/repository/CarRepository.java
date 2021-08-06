package ru.ravilov.ClientBase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.ravilov.ClientBase.model.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    @Query("SELECT p FROM Car p WHERE CONCAT(p.brand, ' ', p.model, ' ', p.bodyType, ' ', p.year, ' ',p.transmission, ' ',p.price,' ',p.country) LIKE %?1%")
    public List<Car> search(String keyword);
}
