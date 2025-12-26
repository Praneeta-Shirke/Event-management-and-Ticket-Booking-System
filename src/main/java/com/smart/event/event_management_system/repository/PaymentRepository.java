package com.smart.event.event_management_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smart.event.event_management_system.entity.Booking;
import com.smart.event.event_management_system.entity.Payment;
import com.smart.event.event_management_system.entity.Payment_status;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long>{
    List<Payment> findBybooking(Booking bid);
    List<Payment> findBypStatus(Payment_status pStatus);
    List<Payment> findAll();
}
