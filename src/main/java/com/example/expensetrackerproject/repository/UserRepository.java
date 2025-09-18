package com.example.expensetrackerproject.repository;

import com.example.expensetrackerproject.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    // This interface extends JpaRepository to provide CRUD operations for User entities.
    // Additional query methods can be defined here if needed.
    Users findByUsername(String username);
}
