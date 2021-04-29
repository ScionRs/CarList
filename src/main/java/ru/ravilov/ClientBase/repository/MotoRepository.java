package ru.ravilov.ClientBase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ravilov.ClientBase.model.Motorcycle;
@Repository
public interface MotoRepository extends JpaRepository<Motorcycle,Long> {
}
