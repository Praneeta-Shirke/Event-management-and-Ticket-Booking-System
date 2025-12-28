package com.smart.event.event_management_system.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pid;

    @OneToOne
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;
    private String mode;

    @Enumerated(EnumType.STRING)
    private Payment_status pStatus;
    private LocalDate paymentDate;

    public long getPid() {
        return pid;
    }
    public void setPid(long pid) {
        this.pid = pid;
    }
    public Booking getBooking() {
        return booking;
    }
    public void setBooking(Booking booking) {
        this.booking = booking;
    }
    public String getMode() {
        return mode;
    }
    public void setMode(String mode) {
        this.mode = mode;
    }
    public Payment_status getPStatus() {
        return pStatus;
    }
    public void setPStatus(Payment_status pStatus) {
        this.pStatus = pStatus;
    }
    public LocalDate getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }
    public Payment() {
    }

    public Payment(long pid, Booking booking, String mode, Payment_status pStatus, LocalDate paymentDate) {
        this.pid = pid;
        this.booking = booking;
        this.mode = mode;
        this.pStatus = pStatus;
        this.paymentDate = paymentDate;
    }
    @Override
    public String toString() {
        return "Payment [pid=" + pid + ", booking=" + booking + ", mode=" + mode + ", pStatus=" + pStatus
                + ", paymentDate=" + paymentDate + "]";
    }
    

    

}
