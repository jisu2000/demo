package com.example.demo.controller;

import com.example.demo.model.UserEO;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private  UserService userService;

    
    // Create user
    @PostMapping
    public ResponseEntity<UserEO> createUser(@RequestBody UserEO user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }

    // Read all users
    @GetMapping
    public ResponseEntity<List<UserEO>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    // Read user by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserEO> getUserById(@PathVariable Integer id) {
        Optional<UserEO> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update user
    @PutMapping("/{id}")
    public ResponseEntity<UserEO> updateUser(@PathVariable Integer id, @RequestBody UserEO userDetails) {
        return ResponseEntity.ok(userService.updateUser(id, userDetails));
    }

    // Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
