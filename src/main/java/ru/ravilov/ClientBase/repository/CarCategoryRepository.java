package ru.ravilov.ClientBase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ravilov.ClientBase.model.CarCategory;

@Repository
public interface CarCategoryRepository extends JpaRepository<CarCategory,Long> {
}
