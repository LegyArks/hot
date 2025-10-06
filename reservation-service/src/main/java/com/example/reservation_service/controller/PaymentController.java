package com.example.reservation_service.controller;

import com.example.reservation_service.entity.Payment;
import com.example.reservation_service.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    private final PaymentService paymentService;
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/post")
    public ResponseEntity<Object> createPayment(@RequestBody Payment payment) {
        return new ResponseEntity<>(paymentService.createPayment(payment), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllPayments() {
        return new ResponseEntity<>(paymentService.getAllPayments(), HttpStatus.OK);
    }

    @GetMapping("/{paymentId}")
    public ResponseEntity<Object> getPayment(@PathVariable Long paymentId) {
        return new ResponseEntity<>(paymentService.getPayment(paymentId), HttpStatus.OK);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<Object> getPaymentsByStatus(@PathVariable String status) {
        return new ResponseEntity<>(paymentService.getPaymentsByStatus(status), HttpStatus.OK);
    }

    @GetMapping("/total-revenue")
    public ResponseEntity<Object> getTotalRevenue() {
        return new ResponseEntity<>(paymentService.getTotalRevenue(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{paymentId}")
    public ResponseEntity<Object> deletePayment(@PathVariable Long paymentId) {
        paymentService.deletePayment(paymentId);
        return new ResponseEntity<>("Payment deleted successfully", HttpStatus.OK);
    }
}

