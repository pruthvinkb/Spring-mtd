package com.example.login.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRequest {
    
    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
    private String username;
    
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;
    
    // Default constructor
    public UserRequest() {
    }
    
    // Parameterized constructor
    public UserRequest(String username, String password) {
        this.username = username;
        this.password = password;
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
}
