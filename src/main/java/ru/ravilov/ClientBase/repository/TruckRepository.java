package ru.ravilov.ClientBase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ravilov.ClientBase.model.Truck;
@Repository
public interface TruckRepository extends JpaRepository<Truck,Long> {
}
