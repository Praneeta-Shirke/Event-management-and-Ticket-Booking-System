package com.smart.event.event_management_system.service.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.smart.event.event_management_system.entity.Booking;
import com.smart.event.event_management_system.entity.Booking_status;
import com.smart.event.event_management_system.entity.Event;
import com.smart.event.event_management_system.entity.User;
import com.smart.event.event_management_system.exception.BadRequestException;
import com.smart.event.event_management_system.exception.ResourceNotFoundException;
import com.smart.event.event_management_system.repository.BookingRepository;
import com.smart.event.event_management_system.repository.EventRepository;
import com.smart.event.event_management_system.repository.UserRepository;
import com.smart.event.event_management_system.service.BookingService;

import jakarta.transaction.Transactional;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    public BookingServiceImpl(BookingRepository bookingRepository,
                              EventRepository eventRepository,
                              UserRepository userRepository) {
        this.bookingRepository = bookingRepository;
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public Booking createBooking(Long userId, Long eventId, int tickets) {

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));

        if (event.getAvailableTickets() < tickets) {
            throw new BadRequestException("Not enough tickets");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setEvent(event);
        booking.setNumOfTickets(tickets);
        booking.setTotalPrice(tickets * event.getPrice());
        booking.setBookingDate(LocalDate.now());
        booking.setBStatus(Booking_status.CONFIRMED);

        event.setAvailableTickets(event.getAvailableTickets() - tickets);

        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getBookingsByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return bookingRepository.findByuser(user);
    }

    @Override
    public List<Booking> getBookingsByEvent(Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
        return bookingRepository.findByevent(event);
    }

    @Override
    public void cancelBooking(Long bookingId) {
        Booking booking = bookingRepository.findById(bookingId.longValue())
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found"));
        booking.setBStatus(Booking_status.CANCELLED);
        bookingRepository.save(booking);
    }

    public List<Booking> getMyBookings(String email) {
        User user = userRepository.findByEmail(email)
            .orElseThrow();
        return bookingRepository.findByUser_Id(user.getId());
}
}
