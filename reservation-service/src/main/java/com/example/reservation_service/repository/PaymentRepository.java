package com.example.reservation_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.reservation_service.entity.*;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
	List<Payment> findByPaymentStatus(String paymentStatus);

}
