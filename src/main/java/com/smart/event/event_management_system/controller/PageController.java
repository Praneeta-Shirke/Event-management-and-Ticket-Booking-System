package com.smart.event.event_management_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/my-bookings")
    public String myBookings() {
        return "my-bookings";
    }

    @GetMapping("/login")
    public String login() { return "login"; }

    @GetMapping("/register")
    public String register() { return "register"; }

    @GetMapping("/events")
    public String events() { return "events"; }

    @GetMapping("/booking")
    public String booking() { return "booking"; }

    @GetMapping("/payment")
    public String payment() { return "payment"; }
}

