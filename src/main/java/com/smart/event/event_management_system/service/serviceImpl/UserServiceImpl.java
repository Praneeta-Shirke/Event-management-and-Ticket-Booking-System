package com.smart.event.event_management_system.service.serviceImpl;

import java.time.LocalDateTime;

import com.smart.event.event_management_system.entity.User;
import com.smart.event.event_management_system.repository.UserRepository;
import com.smart.event.event_management_system.service.UserService;

public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) {
        user.setCreatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email not found"));
    }
}
