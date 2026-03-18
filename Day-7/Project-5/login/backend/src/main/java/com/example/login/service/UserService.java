package com.example.login.service;

import com.example.login.dto.request.UserRequest;
import com.example.login.dto.response.UserResponse;
import com.example.login.entity.User;
import com.example.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    
    private final UserRepository userRepository;
    
    // Constructor injection (recommended over field injection)
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    // Register a new user
    public UserResponse registerUser(UserRequest userRequest) {
        // Check if username already exists
        if (userRepository.existsByUsername(userRequest.getUsername())) {
            throw new RuntimeException("Username already exists: " + userRequest.getUsername());
        }
        
        // Create new user entity
        User user = new User();
        user.setUsername(userRequest.getUsername());
        // Encrypt password before saving
        user.setPassword(encodePassword(userRequest.getPassword()));
        user.setActive(true);
        
        // Save user to database
        User savedUser = userRepository.save(user);
        
        // Convert entity to response DTO
        return convertToUserResponse(savedUser);
    }
    
    // Authenticate user login
    public UserResponse authenticateUser(String username, String password) {
        // Find user by username
        Optional<User> userOptional = userRepository.findByUsername(username);
        
        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found with username: " + username);
        }
        
        User user = userOptional.get();
        
        // Check if user account is active
        if (!user.isActive()) {
            throw new RuntimeException("User account is deactivated");
        }
        
        // Verify password
        if (!verifyPassword(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        
        // Return user response (excluding password)
        return convertToUserResponse(user);
    }
    
    // Helper method to encode password using SHA-256
    private String encodePassword(String plainPassword) {
        try {
            // Create SHA-256 hash
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(plainPassword.getBytes(StandardCharsets.UTF_8));
            
            // Convert to Base64 for storage
            return Base64.getEncoder().encodeToString(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error encoding password", e);
        }
    }
    
    // Helper method to verify password
    private boolean verifyPassword(String plainPassword, String encodedPassword) {
        // Encode the plain password and compare with stored encoded password
        String encodedPlainPassword = encodePassword(plainPassword);
        return encodedPlainPassword.equals(encodedPassword);
    }
    
    // Helper method to convert User entity to UserResponse DTO
    private UserResponse convertToUserResponse(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setActive(user.isActive());
        response.setCreatedAt(user.getCreatedAt());
        response.setUpdatedAt(user.getUpdatedAt());
        
        // Note: Password is intentionally excluded for security
        return response;
    }
}
