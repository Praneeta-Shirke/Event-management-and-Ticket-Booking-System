package com.smart.event.event_management_system.service;

import java.util.List;

import com.smart.event.event_management_system.entity.Booking;

public interface BookingService {
    Booking createBooking(Long userId, Long eventId, int tickets);
    List<Booking> getBookingsByUser(Long userId);
    List<Booking> getBookingsByEvent(Long eventId);
    void cancelBooking(Long bookingId);
    List<Booking> getBookingsForLoggedInUser(String email);
}
