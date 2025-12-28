package com.smart.event.event_management_system.dto;

import java.time.LocalDate;

public class BookingResponseDto {
    private Long bookingId;
    private Long userId;
    private Long eventId;
    private int numberOfTickets;
    private double totalPrice;
    private LocalDate bookingDate;
    private String status;
    
    public BookingResponseDto() {
        // required for Jackson & manual mapping
    }
    
    public BookingResponseDto(Long bookingId, Long userId, Long eventId, int numberOfTickets, double totalPrice,
            LocalDate bookingDate, String status) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.eventId = eventId;
        this.numberOfTickets = numberOfTickets;
        this.totalPrice = totalPrice;
        this.bookingDate = bookingDate;
        this.status = status;
    }
    public Long getBookingId() {
        return bookingId;
    }
    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public Long getEventId() {
        return eventId;
    }
    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }
    public int getNumberOfTickets() {
        return numberOfTickets;
    }
    public void setNumberOfTickets(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public LocalDate getBookingDate() {
        return bookingDate;
    }
    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    
}
