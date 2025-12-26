package com.smart.event.event_management_system.dto;

public class PaymentRequestDto {
    private Integer bookingId;
    private String mode;

    
    public Integer getBookingId() {
        return bookingId;
    }
    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }
    public String getMode() {
        return mode;
    }
    public void setMode(String mode) {
        this.mode = mode;
    }


    
}
