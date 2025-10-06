package com.example.reservation_service.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.reservation_service.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	
	List<Reservation> findByCheckInDateBetween(LocalDate checkInDateStart, LocalDate checkInDateEnd);

}