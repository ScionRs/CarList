package ru.ravilov.ClientBase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.ravilov.ClientBase.model.Car;
import ru.ravilov.ClientBase.model.CarCategory;

import java.util.List;

@Repository
public interface CarCategoryRepository extends JpaRepository<CarCategory,Long> {
}
