package com.smart.event.event_management_system.controller;


import org.springframework.web.bind.annotation.*;

import com.smart.event.event_management_system.dto.PaymentRequestDto;
import com.smart.event.event_management_system.dto.PaymentResponseDto;
import com.smart.event.event_management_system.entity.Payment;
import com.smart.event.event_management_system.service.PaymentService;


@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public PaymentResponseDto makePayment(@RequestBody PaymentRequestDto dto) {

        Payment payment = paymentService.makePayment(
                dto.getBookingId(),
                dto.getMode()
        );

        PaymentResponseDto response = new PaymentResponseDto();
        response.setPaymentId(payment.getPid());
        response.setBookingId(payment.getBooking().getBid());
        response.setMode(payment.getMode());
        response.setStatus(payment.getPStatus().name());
        response.setPaymentDate(payment.getPaymentDate());

        return response;
    }
}

