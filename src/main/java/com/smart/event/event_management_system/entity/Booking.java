package com.smart.event.event_management_system.entity;

import java.time.LocalDate;
// import java.time.OffsetDateTime;
// import org.springframework.data.annotation.CreatedDate;
// import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long bid;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;
    private int numOfTickets;
    private double total_price;
    private LocalDate bookingDate;
    
    @Enumerated(EnumType.STRING)
    private Booking_status b_status;

    public long getbid() {
        return bid;
    }
    public void setbid(long bid) {
        this.bid = bid;
    }
    public User getuser() {
        return user;
    }
    public void setuser(User user) {
        this.user = user;
    }
    public Event getevent() {
        return event;
    }
    public void setevent(Event event) {
        this.event = event;
    }
    public int getNumOfTickets() {
        return numOfTickets;
    }
    public void setNumOfTickets(int numOfTickets) {
        this.numOfTickets = numOfTickets;
    }
    public double getTotal_price() {
        return total_price;
    }
    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }
    public LocalDate getBookingDate() {
        return bookingDate;
    }
    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }
    public Booking_status getb_status() {
        return b_status;
    }
    public void setb_status(Booking_status b_status) {
        this.b_status = b_status;
    }
    public Booking(long bid, User user, Event event, int numOfTickets, double total_price, LocalDate bookingDate,
            Booking_status b_status) {
        this.bid = bid;
        this.user = user;
        this.event = event;
        this.numOfTickets = numOfTickets;
        this.total_price = total_price;
        this.bookingDate = bookingDate;
        this.b_status = b_status;
    }
    @Override
    public String toString() {
        return "Booking [bid=" + bid + ", user=" + user + ", event=" + event + ", numOfTickets=" + numOfTickets
                + ", total_price=" + total_price + ", bookingDate=" + bookingDate + ", b_status=" + b_status
                + ", getbid()=" + getbid() + ", getuser()=" + getuser() + ", getevent()=" + getevent()
                + ", getNumOfTickets()=" + getNumOfTickets() + ", getTotal_price()=" + getTotal_price()
                + ", getBookingDate()=" + getBookingDate() + ", getb_status()=" + getb_status() + ", getClass()="
                + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

    
}
