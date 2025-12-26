package com.smart.event.event_management_system.service;

import com.smart.event.event_management_system.entity.Payment;

public interface PaymentService {
    Payment makePayment(Long bookingId, String mode);
}
