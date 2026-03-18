package com.example.billing.controller;

import com.example.billing.dto.request.UserRequest;
import com.example.billing.dto.response.ApiResponse;
import com.example.billing.entity.UserEntity;
import com.example.billing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<ApiResponse> createUser(@RequestBody UserRequest request) {
        UserEntity user = new UserEntity();
        user.setName(request.getName());
        UserEntity savedUser = userService.createUser(user);
        return ResponseEntity.ok(new ApiResponse("User created successfully", true, savedUser));
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllUsers() {
        List<UserEntity> users = userService.getAllUsers();
        return ResponseEntity.ok(new ApiResponse("Users retrieved successfully", true, users));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getUserById(@PathVariable Long id) {
        Optional<UserEntity> user = userService.getUserById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(new ApiResponse("User found", true, user.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(new ApiResponse("User deleted successfully", true, null));
    }
}