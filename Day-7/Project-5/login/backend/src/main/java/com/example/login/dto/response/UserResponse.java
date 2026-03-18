package com.example.login.dto.response;

import java.time.LocalDateTime;

public class UserResponse {
    
    private Long id;
    private String username;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean active;
    
    // Default constructor
    public UserResponse() {
    }
    
    // Parameterized constructor
    public UserResponse(Long id, String username, LocalDateTime createdAt, LocalDateTime updatedAt, boolean active) {
        this.id = id;
        this.username = username;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.active = active;
    }
    
    // Constructor without timestamps (for simple responses)
    public UserResponse(Long id, String username) {
        this.id = id;
        this.username = username;
        this.active = true;
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
    
    // Getter for active status
    public boolean isActive() {
        return active;
    }
    
    // Setter for active status
    public void setActive(boolean active) {
        this.active = active;
    }
}
