package com.smart.event.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.event.event_management_system.entity.Booking;
import com.smart.event.event_management_system.entity.Booking_status;
import com.smart.event.event_management_system.entity.Event;
import com.smart.event.event_management_system.entity.User;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long>{
    List<Booking> findByuid(User uid);
    List<Booking> findByeid(Event eid);
    List<Booking> findBybStatus(Booking_status bstatus);
}
