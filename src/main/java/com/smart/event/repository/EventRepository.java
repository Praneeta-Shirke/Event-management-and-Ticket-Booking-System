package com.smart.event.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.event.event_management_system.entity.Event;
import com.smart.event.event_management_system.entity.Event_status;

@Repository
public interface EventRepository extends JpaRepository<Event,Long>{
    List<Event> findByDate(LocalDate date);
    List<Event> findByLocation(String Location);
    List<Event> findByStatusEvents(Event_status status);
    List<Event> findByOrganizerId_UId(Long organizerId);
    List<Event> findAll();
}
