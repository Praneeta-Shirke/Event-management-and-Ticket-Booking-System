package com.smart.event.event_management_system.dto;

public class PaymentRequestDto {
    private Long bookingId;
    private String mode;

    
    public Long getBookingId() {
        return bookingId;
    }
    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }
    public String getMode() {
        return mode;
    }
    public void setMode(String mode) {
        this.mode = mode;
    }


    
}
