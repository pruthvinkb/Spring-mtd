package com.example.login.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false, length = 20)
    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    private String username;
    
    @Column(nullable = false)
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;
    
    @Column(nullable = false)
    private boolean active = true;
    
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    // Default constructor (required by JPA)
    public User() {
    }
    
    // Constructor for creating new users
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.active = true;
    }
    
    // Full constructor
    public User(String username, String password, boolean active) {
        this.username = username;
        this.password = password;
        this.active = active;
    }
    
    // Getter for id
    public Long getId() {
        return id;
    }
    
    // Setter for id
    public void setId(Long id) {
        this.id = id;
    }
    
    // Getter for username
    public String getUsername() {
        return username;
    }
    
    // Setter for username
    public void setUsername(String username) {
        this.username = username;
    }
    
    // Getter for password
    public String getPassword() {
        return password;
    }
    
    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }
    
    // Getter for active status
    public boolean isActive() {
        return active;
    }
    
    // Setter for active status
    public void setActive(boolean active) {
        this.active = active;
    }
    
    // Getter for createdAt
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    // Setter for createdAt
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    // Getter for updatedAt
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    // Setter for updatedAt
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}