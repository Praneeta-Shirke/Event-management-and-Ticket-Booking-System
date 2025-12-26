package com.smart.event.event_management_system.service;

import com.smart.event.event_management_system.entity.User;

public interface UserService {
    User registerUser(User user);
    User getUserById(Long userId);
    User getUserByEmail(String email);
}
