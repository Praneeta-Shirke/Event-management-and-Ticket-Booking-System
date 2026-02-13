package com.smart.event.event_management_system.controller.pageController;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/my-bookings")
    public String myBookings() {
        return "my-bookings";
    }
    @GetMapping("/")
    public String index() {return "index";}

    @GetMapping("/organizer")
    public String organizer() {
        return "organizer-dashboard";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin-dashboard";
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

