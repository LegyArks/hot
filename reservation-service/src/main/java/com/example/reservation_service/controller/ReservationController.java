package com.example.reservation_service.controller;

import com.example.reservation_service.entity.Reservation;
import com.example.reservation_service.service.ReservationService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    private final ReservationService reservationService;
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping("/post")
    public ResponseEntity<Object> createReservation(@RequestBody Reservation reservation) {
        return new ResponseEntity<>(reservationService.createReservation(reservation), HttpStatus.OK);
    }

    @GetMapping("/{reservationId}")
    public ResponseEntity<Object> getReservation(@PathVariable Long reservationId) {
        return new ResponseEntity<>(reservationService.getReservation(reservationId), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllReservations() {
        return new ResponseEntity<>(reservationService.getAllReservations(), HttpStatus.OK);
    }

    @PutMapping("/update/{reservationId}")
    public ResponseEntity<Object> updateReservation(@PathVariable Long reservationId, @RequestBody Reservation updatedReservation) {
        return new ResponseEntity<>(reservationService.updateReservation(reservationId, updatedReservation), HttpStatus.OK);
    }

    @GetMapping("/date-range")
    public ResponseEntity<Object> getReservationsBetweenDates(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        return new ResponseEntity<>(reservationService.getReservationsBetweenDates(start, end), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{reservationId}")
    public ResponseEntity<Object> deleteReservation(@PathVariable Long reservationId) {
        reservationService.deleteReservation(reservationId);
        return new ResponseEntity<>("Reservation deleted successfully", HttpStatus.OK);
    }
}
