package ru.ravilov.ClientBase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ravilov.ClientBase.model.ModificationsTruck;
@Repository
public interface ModificationsTruckRepository extends JpaRepository<ModificationsTruck,Long> {
}
