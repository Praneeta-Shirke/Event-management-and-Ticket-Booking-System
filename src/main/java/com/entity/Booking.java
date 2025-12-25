package com.entity;

import java.time.LocalDate;
// import java.time.OffsetDateTime;

// import org.springframework.data.annotation.CreatedDate;

// import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int b_id;
    private int u_id;
    private int e_id;
    private int numOfTickets;
    private int total_price;
    // @CreatedDate
    // @Column(nullable = false, updatable = false)
    private LocalDate bookingDate;
    private boolean Status;
    public int getB_id() {
        return b_id;
    }
    public void setB_id(int b_id) {
        this.b_id = b_id;
    }
    public int getU_id() {
        return u_id;
    }
    public void setU_id(int u_id) {
        this.u_id = u_id;
    }
    public int getE_id() {
        return e_id;
    }
    public void setE_id(int e_id) {
        this.e_id = e_id;
    }
    public int getNumOfTickets() {
        return numOfTickets;
    }
    public void setNumOfTickets(int numOfTickets) {
        this.numOfTickets = numOfTickets;
    }
    public int getTotal_price() {
        return total_price;
    }
    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }
    public LocalDate getBookingDate() {
        return bookingDate;
    }
    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }
    public boolean isStatus() {
        return Status;
    }
    public void setStatus(boolean status) {
        Status = status;
    }
    public Booking(int b_id, int u_id, int e_id, int numOfTickets, int total_price, LocalDate bookingDate,
            boolean status) {
        this.b_id = b_id;
        this.u_id = u_id;
        this.e_id = e_id;
        this.numOfTickets = numOfTickets;
        this.total_price = total_price;
        this.bookingDate = bookingDate;
        Status = status;
    }
    @Override
    public String toString() {
        return "Booking [b_id=" + b_id + ", u_id=" + u_id + ", e_id=" + e_id + ", numOfTickets=" + numOfTickets
                + ", total_price=" + total_price + ", bookingDate=" + bookingDate + ", Status=" + Status
                + ", getB_id()=" + getB_id() + ", getU_id()=" + getU_id() + ", getE_id()=" + getE_id()
                + ", getNumOfTickets()=" + getNumOfTickets() + ", getTotal_price()=" + getTotal_price()
                + ", getBookingDate()=" + getBookingDate() + ", isStatus()=" + isStatus() + ", getClass()=" + getClass()
                + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

    
}
