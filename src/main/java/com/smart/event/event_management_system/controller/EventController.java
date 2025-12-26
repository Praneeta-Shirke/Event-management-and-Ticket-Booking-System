package com.smart.event.event_management_system.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.smart.event.event_management_system.dto.EventRequestDto;
import com.smart.event.event_management_system.dto.EventResponseDto;
import com.smart.event.event_management_system.entity.Event;
import com.smart.event.event_management_system.service.EventService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public ResponseEntity<EventResponseDto> createEvent(@Valid @RequestBody EventRequestDto dto) {

        Event event = new Event();
        event.setTitle(dto.getTitle());
        event.setDescription(dto.getDescription());
        event.setLocation(dto.getLocation());
        event.setEventDate(dto.getEventDate());
        event.setTime(dto.getTime());
        event.setPrice(dto.getPrice());
        event.setTotalTickets(dto.getTotalTickets());

        Event saved = eventService.createEvent(event, dto.getOrganizerId());

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
    public ResponseEntity<String> cancelEvent(@PathVariable Long id) {
        eventService.cancelEvent(id);
        return ResponseEntity.ok("Event cancelled successfully");
    }

    private EventResponseDto mapEvent(Event event) {
        EventResponseDto dto = new EventResponseDto();
        dto.setEventId(event.geteid());
        dto.setTitle(event.getTitle());
        dto.setDescription(event.getDescription());
        dto.setLocation(event.getLocation());
        dto.setEventDate(event.getEventDate());
        dto.setTime(event.getTime());
        dto.setPrice(event.getPrice());
        dto.setTotalTickets(event.getTotalTickets());
        dto.setAvailableTickets(event.getavailableTickets());
        dto.setStatus(event.geteStatus().name());
        dto.setOrganizerId(event.getorganizerid().getId());
        return dto;
    }
}
