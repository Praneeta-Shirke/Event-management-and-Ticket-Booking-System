package com.smart.event.event_management_system.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

import com.smart.event.event_management_system.dto.BookingRequestDto;
import com.smart.event.event_management_system.dto.BookingResponseDto;
import com.smart.event.event_management_system.entity.Booking;
import com.smart.event.event_management_system.service.BookingService;


@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

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
        dto.setBookingId(booking.getbid());
        dto.setUserId(booking.getuser().getId());
        dto.setEventId(booking.getevent().geteid());
        dto.setNumberOfTickets(booking.getNumOfTickets());
        dto.setTotalPrice(booking.gettotalPrice());
        dto.setBookingDate(booking.getBookingDate());
        dto.setStatus(booking.getbStatus().name());
        return dto;
    }
}
