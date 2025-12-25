package com.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Event {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int e_id;
    private String title;
    private String description;
    private String location;
    private LocalDate eventDate;
    private LocalTime time;
    private int price;
    private int total_Ticket;
    private int available_tickets;
    private int organizer_Id;
    private Event_status e_status;
    public int getE_id() {
        return e_id;
    }
    public void setE_id(int e_id) {
        this.e_id = e_id;
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
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public int getTotal_Ticket() {
        return total_Ticket;
    }
    public void setTotal_Ticket(int total_Ticket) {
        this.total_Ticket = total_Ticket;
    }
    public int getAvailable_tickets() {
        return available_tickets;
    }
    public void setAvailable_tickets(int available_tickets) {
        this.available_tickets = available_tickets;
    }
    public int getOrganizer_Id() {
        return organizer_Id;
    }
    public void setOrganizer_Id(int organizer_Id) {
        this.organizer_Id = organizer_Id;
    }
    public Event_status getE_status() {
        return e_status;
    }
    public void setE_status(Event_status e_status) {
        this.e_status = e_status;
    }
    public Event(int e_id, String title, String description, String location, LocalDate eventDate, LocalTime time,
            int price, int total_Ticket, int available_tickets, int organizer_Id, Event_status e_status) {
        this.e_id = e_id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.eventDate = eventDate;
        this.time = time;
        this.price = price;
        this.total_Ticket = total_Ticket;
        this.available_tickets = available_tickets;
        this.organizer_Id = organizer_Id;
        this.e_status = e_status;
    }
    @Override
    public String toString() {
        return "Event [e_id=" + e_id + ", title=" + title + ", description=" + description + ", location=" + location
                + ", eventDate=" + eventDate + ", time=" + time + ", price=" + price + ", total_Ticket=" + total_Ticket
                + ", available_tickets=" + available_tickets + ", organizer_Id=" + organizer_Id + ", e_status="
                + e_status + ", getE_id()=" + getE_id() + ", getTitle()=" + getTitle() + ", getDescription()="
                + getDescription() + ", getLocation()=" + getLocation() + ", getEventDate()=" + getEventDate()
                + ", getTime()=" + getTime() + ", getPrice()=" + getPrice() + ", getTotal_Ticket()=" + getTotal_Ticket()
                + ", getAvailable_tickets()=" + getAvailable_tickets() + ", getOrganizer_Id()=" + getOrganizer_Id()
                + ", getE_status()=" + getE_status() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
                + ", toString()=" + super.toString() + "]";
    }

    
}
