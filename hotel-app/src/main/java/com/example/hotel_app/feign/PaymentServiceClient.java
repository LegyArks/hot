package com.example.hotel_app.feign;

import com.example.hotel_app.dto.PaymentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@FeignClient(name = "reservation-service", url = "http://localhost:8081/api/payment")
public interface PaymentServiceClient {

    @PostMapping("/post")
    PaymentDto createPayment(@RequestBody PaymentDto payment);

    @GetMapping("/all")
    List<PaymentDto> getAllPayments();

    @GetMapping("/{paymentId}")
    PaymentDto getPayment(@PathVariable("paymentId") Long paymentId);

    @GetMapping("/status/{status}")
    List<PaymentDto> getPaymentsByStatus(@PathVariable("status") String status);

    @GetMapping("/total-revenue")
    Double getTotalRevenue();

    @DeleteMapping("/delete/{paymentId}")
    void deletePayment(@PathVariable("paymentId") Long paymentId);
}
