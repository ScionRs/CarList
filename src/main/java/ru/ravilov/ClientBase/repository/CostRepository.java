package ru.ravilov.ClientBase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ravilov.ClientBase.model.Cost;

public interface CostRepository extends JpaRepository<Cost,Long> {

}
