package com.smart.event.event_management_system.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.smart.event.event_management_system.dto.BookingRequestDto;
import com.smart.event.event_management_system.dto.BookingResponseDto;
import com.smart.event.event_management_system.entity.Booking;
import com.smart.event.event_management_system.security.JwtUtil;
import com.smart.event.event_management_system.service.BookingService;
import com.smart.event.event_management_system.service.serviceImpl.BookingServiceImpl;


@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;
    private final JwtUtil jwtUtil;

    public BookingController(BookingService bookingService, JwtUtil jwtUtil) {
        this.bookingService = bookingService;
        this.jwtUtil = jwtUtil;
    }
    
    @PreAuthorize("hasRole('USER')")
    @PostMapping
    public BookingResponseDto createBooking(@RequestBody BookingRequestDto dto) {

        Booking booking = bookingService.createBooking(
                dto.getUserId(),
                dto.getEventId(),
                dto.getNumberOfTickets()
        );

        return mapBooking(booking);
    }

    @GetMapping("/user/{userId}")
    public List<BookingResponseDto> getBookingsByUser(@PathVariable Long userId) {
        return bookingService.getBookingsByUser(userId)
                .stream()
                .map(this::mapBooking)
                .collect(Collectors.toList());
    }

    private BookingResponseDto mapBooking(Booking booking) {
        BookingResponseDto dto = new BookingResponseDto();
        dto.setBookingId(booking.getBid());
        dto.setUserId(booking.getUser().getId());
        dto.setEventId(booking.getEvent().getEid());
        dto.setNumberOfTickets(booking.getNumOfTickets());
        dto.setTotalPrice(booking.getTotalPrice());
        dto.setBookingDate(booking.getBookingDate());
        dto.setStatus(booking.getBStatus().name());
        return dto;
    }

    @GetMapping("/my")
@PreAuthorize("hasRole('USER')")
public List<BookingResponseDto> myBookings(
        @RequestHeader("Authorization") String authHeader) {

    String token = authHeader.substring(7);
    String email = jwtUtil.extractEmail(token);

    return bookingService.getBookingsForLoggedInUser(email)
            .stream()
            .map(this::mapBooking)
            .collect(Collectors.toList());
}

}
