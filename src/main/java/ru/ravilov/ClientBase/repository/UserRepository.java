package ru.ravilov.ClientBase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ravilov.ClientBase.model.User;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
