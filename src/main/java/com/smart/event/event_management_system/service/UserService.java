package com.smart.event.event_management_system.service;

import java.util.List;

import com.smart.event.event_management_system.entity.User;

public interface UserService {
    User registerUser(User user);
    User getUserById(Long userId);
    User getUserByEmail(String email);
    List<User> getAllUsers();
}
