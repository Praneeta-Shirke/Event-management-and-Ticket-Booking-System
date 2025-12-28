package com.smart.event.event_management_system.service.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.smart.event.event_management_system.entity.Event;
import com.smart.event.event_management_system.entity.Event_status;
import com.smart.event.event_management_system.entity.User;
import com.smart.event.event_management_system.exception.ResourceNotFoundException;
import com.smart.event.event_management_system.repository.EventRepository;
import com.smart.event.event_management_system.repository.UserRepository;
import com.smart.event.event_management_system.service.EventService;

@Service
public class EventServiceImpl implements EventService{
    
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public EventServiceImpl(EventRepository eventRepository,
                            UserRepository userRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Event createEvent(Event event, Long organizerId) {
        User organizer = userRepository.findById(organizerId)
                .orElseThrow(() -> new ResourceNotFoundException("Organizer not found"));

        event.setOrganizerid(organizer);
        event.setEStatus(Event_status.ACTIVE);
        event.setAvailableTickets(event.getTotalTickets());


        return eventRepository.save(event);
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public List<Event> getActiveEvents() {
        return eventRepository.findByeStatus(Event_status.ACTIVE);
    }

    @Override
    public List<Event> getEventsByDate(LocalDate date) {
        return eventRepository.findByEventDate(date);
    }

    @Override
    public Event getEventById(Long eventId) {
        return eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
    }

    @Override
    public void cancelEvent(Long eventId) {
        Event event = eventRepository.findById(eventId)
        .orElseThrow(() -> new ResourceNotFoundException("Event not found with id " + eventId));

        event.setEStatus(Event_status.CANCELLED);
        eventRepository.save(event);
    }

    
}
