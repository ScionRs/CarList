package ru.ravilov.ClientBase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ravilov.ClientBase.model.ModificationAuto;

@Repository
public interface ModificationsAutoRepository extends JpaRepository<ModificationAuto,Long> {
}
