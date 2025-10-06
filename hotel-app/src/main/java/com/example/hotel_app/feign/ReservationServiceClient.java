package com.example.hotel_app.feign;

import com.example.hotel_app.dto.*;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@FeignClient(name = "reservation-service", url = "http://localhost:8081/api/reservation")
public interface ReservationServiceClient {

    @PostMapping("/post")
    ReservationDto createReservation(@RequestBody ReservationDto reservation);

    @GetMapping("/{reservationId}")
    ReservationDto getReservation(@PathVariable("reservationId") Long reservationId);

    @GetMapping("/all")
    List<ReservationDto> getAllReservations();

    @PutMapping("/update/{reservationId}")
    ReservationDto updateReservation(@PathVariable("reservationId") Long reservationId, @RequestBody ReservationDto reservation);

    @DeleteMapping("/delete/{reservationId}")
    void deleteReservation(@PathVariable("reservationId") Long reservationId);
    
    @GetMapping("/date-range")
    List<ReservationDto> getReservationsBetweenDates(LocalDate startDate, LocalDate endDate);
}
