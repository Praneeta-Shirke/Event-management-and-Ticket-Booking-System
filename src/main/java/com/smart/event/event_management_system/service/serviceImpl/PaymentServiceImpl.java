package com.smart.event.event_management_system.service.serviceImpl;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.smart.event.event_management_system.entity.Booking;
import com.smart.event.event_management_system.service.PaymentService;
import com.smart.event.event_management_system.entity.Payment;
import com.smart.event.event_management_system.entity.Payment_status;
import com.smart.event.event_management_system.repository.BookingRepository;
import com.smart.event.event_management_system.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final BookingRepository bookingRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository,
                              BookingRepository bookingRepository) {
        this.paymentRepository = paymentRepository;
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Payment makePayment(Integer bookingId, String mode) {

        Booking booking = bookingRepository.findById(bookingId.longValue())
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        Payment payment = new Payment();
        payment.setbooking(booking);
        payment.setMode(mode);
        payment.setpStatus(Payment_status.SUCCESS);
        payment.setPaymentDate(LocalDate.now());

        return paymentRepository.save(payment);
    }
}
