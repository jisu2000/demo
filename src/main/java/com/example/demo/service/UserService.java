package com.example.demo.service;

import com.example.demo.model.UserEO;
import com.example.demo.repo.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create operation
    public UserEO createUser(UserEO user) {
        return userRepository.save(user);
    }

    // Read operation
    public List<UserEO> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserEO> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    // Update operation
    public UserEO updateUser(Integer id, UserEO userDetails) {
        UserEO user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());

        return userRepository.save(user);
    }

    // Delete operation
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
