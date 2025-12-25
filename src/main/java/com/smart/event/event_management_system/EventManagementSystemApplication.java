package com.smart.event.event_management_system;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.smart.event.event_management_system.repository.UserRepository;


@SpringBootApplication
public class EventManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventManagementSystemApplication.class, args);
    }

    @Bean
    CommandLineRunner test(UserRepository userRepo) {
        return args -> {
            System.out.println("Users in DB: " + userRepo.findAll());
        };
    }
}
