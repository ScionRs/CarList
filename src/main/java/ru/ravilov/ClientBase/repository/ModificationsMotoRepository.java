package ru.ravilov.ClientBase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ravilov.ClientBase.model.ModificationMoto;

@Repository
public interface ModificationsMotoRepository extends JpaRepository<ModificationMoto,Long> {
}
