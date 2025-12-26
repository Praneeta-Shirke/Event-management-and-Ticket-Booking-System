package com.smart.event.event_management_system.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Events")
public class Event {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long eid;
    private String title;
    private String description;
    private String location;
    private LocalDate eventDate;
    private LocalTime time;
    private double price;
    @Column(name="total_tickets",nullable = false)
    private int totalTickets = 0;
    @Column(name="available_tickets")
    private int availableTickets;
    
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "organizer_id", nullable = false)
    @JsonIgnore
    private User organizerid;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Event_status eStatus;


    public long geteid() {
        return eid;
    }
    public void seteid(long eid) {
        this.eid = eid;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public LocalDate getEventDate() {
        return eventDate;
    }
    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }
    public LocalTime getTime() {
        return time;
    }
    public void setTime(LocalTime time) {
        this.time = time;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getTotalTickets() {
        return totalTickets;
    }
    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }
    public int getavailableTickets() {
        return availableTickets;
    }
    public void setavailableTickets(int availableTickets) {
        this.availableTickets = availableTickets;
    }
    public User getorganizerid() {
        return organizerid;
    }
    public void setorganizerid(User organizerid) {
        this.organizerid = organizerid;
    }
    public Event_status geteStatus() {
        return eStatus;
    }
    public void seteStatus(Event_status eStatus) {
        this.eStatus = eStatus;
    }
    public Event(long eid, String title, String description, String location, LocalDate eventDate, LocalTime time,
            double price, int totalTickets, int availableTickets, User organizerid, Event_status eStatus) {
        this.eid = eid;
        this.title = title;
        this.description = description;
        this.location = location;
        this.eventDate = eventDate;
        this.time = time;
        this.price = price;
        this.totalTickets = totalTickets;
        this.availableTickets = availableTickets;
        this.organizerid = organizerid;
        this.eStatus = eStatus;
    }
    public Event() {
        //TODO Auto-generated constructor stub
    }
    @Override
    public String toString() {
        return "Event [eid=" + eid + ", title=" + title + ", description=" + description + ", location=" + location
                + ", eventDate=" + eventDate + ", time=" + time + ", price=" + price + ", totalTickets=" + totalTickets
                + ", availableTickets=" + availableTickets + ", eStatus="
                + eStatus + "]";
    }

    
}
