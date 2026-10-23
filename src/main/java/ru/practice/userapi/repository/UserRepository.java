package ru.practice.userapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practice.userapi.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
