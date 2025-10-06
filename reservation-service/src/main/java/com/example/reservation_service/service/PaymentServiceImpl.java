package com.example.reservation_service.service;


import com.example.reservation_service.entity.Payment;
import com.example.reservation_service.entity.Reservation;
import com.example.reservation_service.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final ReservationRepository reservationRepository;

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository, ReservationRepository reservationRepository) {
		this.paymentRepository = paymentRepository;
		this.reservationRepository = reservationRepository;
	}

    @Override
	public Payment createPayment(Payment payment) {
        if (payment.getReservation() != null && payment.getReservation().getReservationId() != null) {
            Reservation res = reservationRepository.findById(payment.getReservation().getReservationId())
                    .orElseThrow(() -> new RuntimeException("Reservation not found"));
            payment.setReservation(res);
        } else {
            throw new RuntimeException("Reservation ID missing in payment request");
        }

        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPayment(Long paymentId) {
        return paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found with id " + paymentId));
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public List<Payment> getPaymentsByStatus(String status) {
        return paymentRepository.findByPaymentStatus(status);
    }

    @Override
    public Double getTotalRevenue() {
        return paymentRepository.findAll().stream()
                .filter(p -> "Paid".equalsIgnoreCase(p.getPaymentStatus()))
                .mapToDouble(Payment::getAmount)
                .sum();
    }

    @Override
    public void deletePayment(Long paymentId) {
        paymentRepository.deleteById(paymentId);
    }
}
