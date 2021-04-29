package ru.ravilov.ClientBase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ravilov.ClientBase.model.TruckCategory;
@Repository
public interface TruckCategoryRepository extends JpaRepository<TruckCategory,Long> {
}
