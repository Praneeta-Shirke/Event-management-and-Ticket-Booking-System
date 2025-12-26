package com.smart.event.event_management_system.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventRequestDto {
    private String title;
    private String description;
    private String location;
    private LocalDate eventDate;
    private LocalTime time;
    private double price;
    private int totalTickets;
    private Long organizerId;
    
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
    public Long getOrganizerId() {
        return organizerId;
    }
    public void setOrganizerId(Long organizerId) {
        this.organizerId = organizerId;
    }

    
}
