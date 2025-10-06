package com.example.reservation_service.service;

import com.example.reservation_service.entity.Reservation;

import java.time.LocalDate;
import java.util.List;

public interface ReservationService {
	
	Reservation createReservation(Reservation reservation);
	
    Reservation getReservation(Long reservationId);
    
    List<Reservation> getAllReservations();
    
    Reservation updateReservation(Long reservationId, Reservation updatedReservation);
    
    void deleteReservation(Long reservationId);
    
    List<Reservation> getReservationsBetweenDates(LocalDate startDate, LocalDate endDate);
    
}
