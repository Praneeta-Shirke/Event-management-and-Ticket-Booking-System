package com.smart.event.event_management_system.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.event.event_management_system.dto.UserRequestDto;
import com.smart.event.event_management_system.entity.Role;
import com.smart.event.event_management_system.entity.User;
import com.smart.event.event_management_system.service.UserService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/create")
    @PreAuthorize("hasRole('ADMIN')")
    public User createAdmin(@RequestBody UserRequestDto dto) {
        User admin = new User();
        admin.setName(dto.getName());
        admin.setEmail(dto.getEmail());
        admin.setPassword(dto.getPassword());
        admin.setRole(Role.ADMIN);
        return userService.registerUser(admin);
    }
}
