Smart Event Management and Ticket Booking System
📌 Project Overview

The Smart Event Management and Ticket Booking System is a web-based application designed to simplify the process of managing events and booking tickets online.
It provides a centralized platform for users, event organizers, and administrators to interact efficiently through role-based access.

This project is developed using Java, Spring Boot, MySQL for the backend and HTML/CSS for the frontend, following industry-standard layered architecture.

🎯 Objectives

  To automate event creation, approval, and management
  To allow users to browse events and book tickets online
  To maintain secure, role-based access for different users
  To ensure data consistency and prevent ticket overbooking

👥 User Roles

Customer
  ~ Register and login
  ~ Browse events
  ~ Book tickets
  ~ View booking history
  ~ Event Organizer
  ~ Create and manage events
  ~ Set ticket prices and capacity
  ~ View bookings for their events

Organizer
  ~ Create event
  ~ Update event details
  ~ Upload banner/image
  ~ Set ticket price and capacity
  ~ View bookings for their event

Admin
  ~ Approve or reject events
  ~ Manage users and organizers
  ~ View all events and bookings

🛠️ Technology Stack
Backend
  Java 17
  Spring Boot
  Spring Data JPA (Hibernate)
  Spring Security
  MySQL

Frontend
  HTML
  CSS

Tools
  VS Code / Eclipse
  MySQL Workbench
  Git & GitHub

🗄️ Database Design
Main Tables
  users
  events
  bookings
  payments (optional)

Relationships
  One organizer can create multiple events
  One user can make multiple bookings
  Each booking is linked to one event

(ER Diagram will be included in documentation)

🔑 Key Features
  ~ User registration and authentication
  ~ Role-based authorization (USER / ORGANIZER / ADMIN)
  ~ Event creation and approval workflow
  ~ Ticket booking with availability validation
  ~ Transaction-safe booking process
  ~ Admin dashboard management

⚙️ Setup Instructions
  Prerequisites
    Java 17+
    MySQL
    Maven
    Git

Steps to Run Backend:

Clone the repository:
  git clone https://github.com/Praneeta-Shirke/Event-management-and-Ticket-Booking-System.git

Open project

Configure application.properties:
  spring.datasource.url=jdbc:mysql://localhost:3306/event_db
  spring.datasource.username=root
  spring.datasource.password=your_password
  spring.jpa.hibernate.ddl-auto=update

Run the Spring Boot application

Access backend at:
  http://localhost:8080


🚀 Future Enhancements
  Online payment gateway integration
  QR code–based tickets
  Email notifications
  Advanced search and filters
  Admin analytics dashboard
