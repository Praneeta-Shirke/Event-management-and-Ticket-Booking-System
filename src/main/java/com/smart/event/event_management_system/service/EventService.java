package com.smart.event.event_management_system.service;

import java.time.LocalDate;
import java.util.List;

import com.smart.event.event_management_system.dto.EventResponseDto;
import com.smart.event.event_management_system.entity.Event;


public interface EventService {
    Event createEvent(Event event, Long email);
    List<Event> getAllEvents();
    List<Event> getActiveEvents();
    List<Event> getEventsByDate(LocalDate date);
    Event getEventById(Long eventId);
    void cancelEvent(Long eventId);
    List<EventResponseDto> getEventsByOrganizer(String Email);
}
