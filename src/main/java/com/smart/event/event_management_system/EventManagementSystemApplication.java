package com.smart.event.event_management_system;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.smart.event.event_management_system.entity.Role;
import com.smart.event.event_management_system.entity.User;
import com.smart.event.event_management_system.repository.UserRepository;
import com.smart.event.event_management_system.service.UserService;

@SpringBootApplication
public class EventManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventManagementSystemApplication.class, args);
    }

    @Bean
    CommandLineRunner seedDemoAdmin(UserRepository userRepository, UserService userService) {
        return args -> {
            String demoAdminEmail = "admin.demo@smart-event.local";

            if (userRepository.findByEmail(demoAdminEmail).isEmpty()) {
                User admin = new User();
                admin.setName("Demo Admin");
                admin.setEmail(demoAdminEmail);
                admin.setPassword("Admin@123");
                admin.setRole(Role.ADMIN);
                userService.registerUser(admin);
                System.out.println("Demo admin created: " + demoAdminEmail);
            }
        };
    }
}
