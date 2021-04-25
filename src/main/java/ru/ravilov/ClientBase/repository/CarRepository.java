package ru.ravilov.ClientBase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.ravilov.ClientBase.model.Car;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {
    @Query("SELECT p FROM Brand p WHERE CONCAT(p.Brand, ' ', p.model, ' ', p.BodyType, ' ', p.year, ' ',p.transmission, ' ',p.price) LIKE %?1%")
    public List<Car> search(String keyword);
}
