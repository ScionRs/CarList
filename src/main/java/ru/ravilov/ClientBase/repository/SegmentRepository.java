package ru.ravilov.ClientBase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ravilov.ClientBase.model.Segment;
@Repository
public interface SegmentRepository extends JpaRepository<Segment,Long> {
}
