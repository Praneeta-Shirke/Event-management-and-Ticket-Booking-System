package com.smart.event.event_management_system.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smart.event.event_management_system.dto.LoginRequestDto;
import com.smart.event.event_management_system.dto.LoginResponseDto;
import com.smart.event.event_management_system.entity.User;
import com.smart.event.event_management_system.exception.BadRequestException;
import com.smart.event.event_management_system.security.JwtUtil;
import com.smart.event.event_management_system.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public LoginResponseDto login(@RequestBody LoginRequestDto dto) {

        User user = userService.getUserByEmail(dto.getEmail());

        if (!user.getPassword().equals(dto.getPassword())) {
            throw new BadRequestException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user);

        LoginResponseDto response = new LoginResponseDto();
        response.setToken(token);
        response.setRole(user.getRole().name());

        return response;
    }
}
