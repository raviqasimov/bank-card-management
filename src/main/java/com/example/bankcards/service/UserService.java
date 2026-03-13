package com.example.bankcards.service;

import com.example.bankcards.dto.RegisterRequest;
import com.example.bankcards.entity.User;

import java.util.List;

public interface UserService {
    List<User>getAllUsers();
    User getUserById(Long id);
    User saveUser(User user);
    void deleteUser(Long id);
    User register(RegisterRequest request);
    User findByUsername(String username);
}
