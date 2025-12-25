package com.smart.event.event_management_system.entity;

import java.time.LocalDate;
import java.time.LocalTime;

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
    private int totalTickets;
    private int availableTickets;
    
    @ManyToOne
    @JoinColumn(name = "organizer_id", nullable = false)
    private User organizer_Id;
    
    @Enumerated(EnumType.STRING)
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
    public int gettotalTickets() {
        return totalTickets;
    }
    public void settotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }
    public int getavailableTickets() {
        return availableTickets;
    }
    public void setavailableTickets(int availableTickets) {
        this.availableTickets = availableTickets;
    }
    public User getOrganizer_Id() {
        return organizer_Id;
    }
    public void setOrganizer_Id(User organizer_Id) {
        this.organizer_Id = organizer_Id;
    }
    public Event_status geteStatus() {
        return eStatus;
    }
    public void seteStatus(Event_status eStatus) {
        this.eStatus = eStatus;
    }
    public Event(long eid, String title, String description, String location, LocalDate eventDate, LocalTime time,
            double price, int totalTickets, int availableTickets, User organizer_Id, Event_status eStatus) {
        this.eid = eid;
        this.title = title;
        this.description = description;
        this.location = location;
        this.eventDate = eventDate;
        this.time = time;
        this.price = price;
        this.totalTickets = totalTickets;
        this.availableTickets = availableTickets;
        this.organizer_Id = organizer_Id;
        this.eStatus = eStatus;
    }
    @Override
    public String toString() {
        return "Event [eid=" + eid + ", title=" + title + ", description=" + description + ", location=" + location
                + ", eventDate=" + eventDate + ", time=" + time + ", price=" + price + ", totalTickets=" + totalTickets
                + ", availableTickets=" + availableTickets + ", organizer_Id=" + organizer_Id + ", eStatus="
                + eStatus + ", geteid()=" + geteid() + ", getTitle()=" + getTitle() + ", getDescription()="
                + getDescription() + ", getLocation()=" + getLocation() + ", getEventDate()=" + getEventDate()
                + ", getTime()=" + getTime() + ", getPrice()=" + getPrice() + ", gettotalTickets()=" + gettotalTickets()
                + ", getavailableTickets()=" + getavailableTickets() + ", getOrganizer_Id()=" + getOrganizer_Id()
                + ", geteStatus()=" + geteStatus() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + ", toString()=" + super.toString() + "]";
    }

    
}
