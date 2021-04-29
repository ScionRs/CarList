package ru.ravilov.ClientBase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ravilov.ClientBase.model.MotorcycleCategory;
@Repository
public interface MotoCategoryRepository extends JpaRepository<MotorcycleCategory,Long> {
}
