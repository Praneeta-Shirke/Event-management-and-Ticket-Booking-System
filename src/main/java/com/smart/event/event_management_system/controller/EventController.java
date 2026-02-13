package com.smart.event.event_management_system.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.smart.event.event_management_system.dto.EventRequestDto;
import com.smart.event.event_management_system.dto.EventResponseDto;
import com.smart.event.event_management_system.entity.Event;
import com.smart.event.event_management_system.security.JwtUtil;
import com.smart.event.event_management_system.service.EventService;
import com.smart.event.event_management_system.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;
    private final JwtUtil jwtUtil;
    private final UserService userService;

    public EventController(EventService eventService, JwtUtil jwtUtil, UserService userService) {
        this.eventService = eventService;
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    @PreAuthorize("hasRole('ORGANIZER')")
    @PostMapping
    public ResponseEntity<EventResponseDto> createEvent(
            @Valid @RequestBody EventRequestDto dto,
            @RequestHeader("Authorization") String authHeader) {

        Event event = new Event();
        event.setTitle(dto.getTitle());
        event.setDescription(dto.getDescription());
        event.setLocation(dto.getLocation());
        event.setEventDate(dto.getEventDate());
        event.setTime(dto.getTime());
        event.setPrice(dto.getPrice());
        event.setTotalTickets(dto.getTotalTickets());

        String email = jwtUtil.extractEmail(authHeader.substring(7));
        Long organizerId = userService.getUserByEmail(email).getId();

        Event saved = eventService.createEvent(event, organizerId);

        return new ResponseEntity<>(mapEvent(saved), HttpStatus.CREATED);
    }

    @GetMapping
    public List<EventResponseDto> getAllActiveEvents() {
        return eventService.getActiveEvents()
                .stream()
                .map(this::mapEvent)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EventResponseDto getEventById(@PathVariable Long id) {
        return mapEvent(eventService.getEventById(id));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> cancelEvent(@PathVariable Long id) {
        eventService.cancelEvent(id);
        System.out.println("CANCEL EVENT CONTROLLER HIT: " + id);
        return ResponseEntity.ok("Event cancelled successfully");
    }

    private EventResponseDto mapEvent(Event event) {
        EventResponseDto dto = new EventResponseDto();
        dto.setEventId(event.getEid());
        dto.setTitle(event.getTitle());
        dto.setDescription(event.getDescription());
        dto.setLocation(event.getLocation());
        dto.setEventDate(event.getEventDate());
        dto.setTime(event.getTime());
        dto.setPrice(event.getPrice());
        dto.setTotalTickets(event.getTotalTickets());
        dto.setAvailableTickets(event.getAvailableTickets());
        dto.setStatus(event.getEStatus().name());
        dto.setOrganizerId(event.getOrganizerid().getId());
        return dto;
    }

    @GetMapping("/my")
    @PreAuthorize("hasRole('ORGANIZER')")
    public List<EventResponseDto> myEvents(
        @RequestHeader("Authorization") String authHeader) {

        String email = jwtUtil.extractEmail(authHeader.substring(7));
        return eventService.getEventsByOrganizer(email);
    }

}
