package com.example.hotel_app.controller;

import com.example.hotel_app.dto.*;
import com.example.hotel_app.feign.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/reservation")
public class ReservationControllerMvc {

    private final ReservationServiceClient reservationClient;
    private final UserServiceClient userClient;

    public ReservationControllerMvc(ReservationServiceClient reservationClient, UserServiceClient userClient) {
        this.reservationClient = reservationClient;
        this.userClient = userClient;
    }

    @GetMapping("/all")
    public String getAllReservations(Model model) {
        model.addAttribute("reservations", reservationClient.getAllReservations());
        return "reservation/list";
    }

    @GetMapping("/add")
    public String addReservationForm(Model model) {
        model.addAttribute("reservation", new ReservationDto());
        model.addAttribute("users", userClient.getAllUsers());
        return "reservation/add";
    }

    @PostMapping("/save")
    public String saveReservation(@ModelAttribute("reservation") ReservationDto reservation) {
        reservationClient.createReservation(reservation);
        return "redirect:/reservation/all";
    }

    @GetMapping("/edit/{id}")
    public String editReservationForm(@PathVariable Long id, Model model) {
        model.addAttribute("reservation", reservationClient.getReservation(id));
        model.addAttribute("users", userClient.getAllUsers());
        return "reservation/edit";
    }

    @PostMapping("/update/{id}")
    public String updateReservation(@PathVariable Long id, @ModelAttribute("reservation") ReservationDto reservation) {
        reservationClient.updateReservation(id, reservation);
        return "redirect:/reservation/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteReservation(@PathVariable Long id) {
        reservationClient.deleteReservation(id);
        return "redirect:/reservation/all";
    }

    @GetMapping("/date-range")
    public String getReservationsByDateRange(@RequestParam String startDate, @RequestParam String endDate, Model model) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        model.addAttribute("reservations", reservationClient.getReservationsBetweenDates(start, end));
        return "reservation/list";
    }
}
