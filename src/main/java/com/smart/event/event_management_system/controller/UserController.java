package com.smart.event.event_management_system.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.smart.event.event_management_system.dto.UserRequestDto;
import com.smart.event.event_management_system.dto.UserResponseDto;
import com.smart.event.event_management_system.entity.Role;
import com.smart.event.event_management_system.entity.User;
import com.smart.event.event_management_system.service.UserService;


@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> registerUser(@RequestBody UserRequestDto dto) {

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(Role.valueOf(dto.getRole().toUpperCase()));

        User saved = userService.registerUser(user);

        UserResponseDto response = new UserResponseDto();
        response.setUserId(saved.getId());
        response.setName(saved.getName());
        response.setEmail(saved.getEmail());
        response.setRole(saved.getRole().name());
        response.setCreatedAt(saved.getCreatedAt());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
