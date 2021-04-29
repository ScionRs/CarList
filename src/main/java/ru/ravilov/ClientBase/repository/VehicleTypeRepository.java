package ru.ravilov.ClientBase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ravilov.ClientBase.model.VehicleType;
@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleType,Long> {
}
