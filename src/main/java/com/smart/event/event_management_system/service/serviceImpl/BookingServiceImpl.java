package com.smart.event.event_management_system.service.serviceImpl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.smart.event.event_management_system.entity.Booking;
import com.smart.event.event_management_system.entity.Booking_status;
import com.smart.event.event_management_system.entity.Event;
import com.smart.event.event_management_system.entity.User;
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

        Event event = eventRepository.findByeid(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        if (event.getavailableTickets() < tickets) {
            throw new RuntimeException("Not enough tickets");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Booking booking = new Booking();
        booking.setuser(user);
        booking.setevent(event);
        booking.setNumOfTickets(tickets);
        booking.settotalPrice(tickets * event.getPrice());
        booking.setBookingDate(LocalDate.now());
        booking.setbStatus(Booking_status.CONFIRMED);

        event.setavailableTickets(event.getavailableTickets() - tickets);

        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getBookingsByUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return bookingRepository.findByuser(user);
    }

    @Override
    public List<Booking> getBookingsByEvent(Integer eventId) {
        Event event = eventRepository.findByeid(eventId)
                .orElseThrow(() -> new RuntimeException("Event not found"));
        return bookingRepository.findByevent(event);
    }

    @Override
    public void cancelBooking(Integer bookingId) {
        Booking booking = bookingRepository.findById(bookingId.longValue())
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        booking.setbStatus(Booking_status.CANCELLED);
        bookingRepository.save(booking);
    }
}
