package ru.ravilov.ClientBase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ravilov.ClientBase.model.Generation;

public interface GenerationRepository extends JpaRepository<Generation,Long> {
}
