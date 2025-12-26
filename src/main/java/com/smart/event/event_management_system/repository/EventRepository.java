package com.smart.event.event_management_system.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.event.event_management_system.entity.Event;
import com.smart.event.event_management_system.entity.Event_status;

@Repository
public interface EventRepository extends JpaRepository<Event,Long>{
    List<Event> findByEventDate(LocalDate date);
    List<Event> findByLocation(String Location);
    List<Event> findByeStatus(Event_status eStatus);
    List<Event> findByorganizerid(Long organizerId);
    List<Event> findAll();
    Optional<Event> findByeid(Integer eventId);
}
