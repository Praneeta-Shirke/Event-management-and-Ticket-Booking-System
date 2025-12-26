package com.smart.event.event_management_system;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.smart.event.event_management_system.service.EventService;

@SpringBootApplication
public class EventManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventManagementSystemApplication.class, args);
    }

    @Bean
    CommandLineRunner test(EventService eventService) {
        return args -> {
            System.out.println(eventService.getActiveEvents());
        };
    }
}
