package ru.ravilov.ClientBase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ravilov.ClientBase.model.BrandCategory;

@Repository
public interface BrandCategoryRepository extends JpaRepository<BrandCategory,Integer> {
}
