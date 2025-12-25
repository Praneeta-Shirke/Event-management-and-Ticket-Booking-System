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
    private Payment_status p_status;
    private LocalDate paymentDate;

    public long getpid() {
        return pid;
    }
    public void setpid(long pid) {
        this.pid = pid;
    }
    public Booking getbooking() {
        return booking;
    }
    public void setbooking(Booking booking) {
        this.booking = booking;
    }
    public String getMode() {
        return mode;
    }
    public void setMode(String mode) {
        this.mode = mode;
    }
    public Payment_status getP_status() {
        return p_status;
    }
    public void setP_status(Payment_status p_status) {
        this.p_status = p_status;
    }
    public LocalDate getPaymentDate() {
        return paymentDate;
    }
    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }
    public Payment(long pid, Booking booking, String mode, Payment_status p_status, LocalDate paymentDate) {
        this.pid = pid;
        this.booking = booking;
        this.mode = mode;
        this.p_status = p_status;
        this.paymentDate = paymentDate;
    }
    @Override
    public String toString() {
        return "Payment [pid=" + pid + ", booking=" + booking + ", mode=" + mode + ", p_status=" + p_status
                + ", paymentDate=" + paymentDate + ", getpid()=" + getpid() + ", getbooking()=" + getbooking()
                + ", getMode()=" + getMode() + ", getP_status()=" + getP_status() + ", getPaymentDate()="
                + getPaymentDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
                + super.toString() + "]";
    }

    

}
