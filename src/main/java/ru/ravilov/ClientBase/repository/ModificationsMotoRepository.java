package ru.ravilov.ClientBase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ravilov.ClientBase.model.ModificationsMoto;

@Repository
public interface ModificationsMotoRepository extends JpaRepository<ModificationsMoto,Long> {
}
