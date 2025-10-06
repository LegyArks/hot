package com.example.reservation_service.service;


import com.example.reservation_service.entity.Payment;
import java.util.List;

public interface PaymentService {
    Payment createPayment(Payment payment);
    
    Payment getPayment(Long paymentId);
    
    List<Payment> getAllPayments();
    
    List<Payment> getPaymentsByStatus(String status);
    
    Double getTotalRevenue();
    
    void deletePayment(Long paymentId);
}
