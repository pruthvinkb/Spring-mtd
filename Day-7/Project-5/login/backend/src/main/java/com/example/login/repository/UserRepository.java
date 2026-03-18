package com.example.login.repository;

import com.example.login.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Find user by username (for login authentication)
    Optional<User> findByUsername(String username);
    
    // Check if username already exists (for registration validation)
    boolean existsByUsername(String username);
}
