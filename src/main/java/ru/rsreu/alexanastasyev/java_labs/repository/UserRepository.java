package ru.rsreu.alexanastasyev.java_labs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rsreu.alexanastasyev.java_labs.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUsername(String username);
}
