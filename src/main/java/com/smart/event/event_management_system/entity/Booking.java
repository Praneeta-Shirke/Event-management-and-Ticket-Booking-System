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
    private double totalPrice;
    private LocalDate bookingDate;
    
    @Enumerated(EnumType.STRING)
    private Booking_status bStatus;

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
    public double gettotalPrice() {
        return totalPrice
;
    }
    public void settotalPrice(double totalPrice

    ) {
        this.totalPrice
 = totalPrice
;
    }
    public LocalDate getBookingDate() {
        return bookingDate;
    }
    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }
    public Booking_status getbStatus() {
        return bStatus;
    }
    public void setbStatus(Booking_status bStatus) {
        this.bStatus = bStatus;
    }
    public Booking() {}

    public Booking(long bid, User user, Event event, int numOfTickets, double totalPrice
, LocalDate bookingDate,
            Booking_status bStatus) {
        this.bid = bid;
        this.user = user;
        this.event = event;
        this.numOfTickets = numOfTickets;
        this.totalPrice
 = totalPrice
;
    @Override
    public String toString() {
        return "Booking [bid=" + bid + ", user=" + user + ", event=" + event + ", numOfTickets=" + numOfTickets
                + ", totalPrice =" + totalPrice+ ", bookingDate=" + bookingDate + ", bStatus=" + bStatus
                + ", getbid()=" + getbid() + ", getuser()=" + getuser() + ", getevent()=" + getevent()
                + ", getNumOfTickets()=" + getNumOfTickets() + ", gettotalPrice()=" + gettotalPrice()
                + ", getBookingDate()=" + getBookingDate() + ", getbStatus()=" + getbStatus() + ", getClass()="
                + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
    }

    
}
