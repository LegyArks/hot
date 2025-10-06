package com.example.hotel_app.controller;

import com.example.hotel_app.dto.*;
import com.example.hotel_app.feign.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/payment")
public class PaymentControllerMvc {

    private final PaymentServiceClient paymentClient;
    private final ReservationServiceClient reservationClient;

    public PaymentControllerMvc(PaymentServiceClient paymentClient, ReservationServiceClient reservationClient) {
        this.paymentClient = paymentClient;
        this.reservationClient = reservationClient;
    }

    @GetMapping("/all")
    public String getAllPayments(Model model) {
        model.addAttribute("payments", paymentClient.getAllPayments());
        return "payment/list";
    }

    @GetMapping("/add")
    public String addPaymentForm(Model model) {
        model.addAttribute("payment", new PaymentDto());
        model.addAttribute("reservations", reservationClient.getAllReservations());
        return "payment/add";
    }

    @PostMapping("/save")
    public String savePayment(@ModelAttribute("payment") PaymentDto payment) {
        paymentClient.createPayment(payment);
        return "redirect:/payment/all";
    }

    @GetMapping("/edit/{id}")
    public String editPaymentForm(@PathVariable Long id, Model model) {
        model.addAttribute("payment", paymentClient.getPayment(id));
        model.addAttribute("reservations", reservationClient.getAllReservations());
        return "payment/edit";
    }

//    @PostMapping("/update/{id}")
//    public String updatePayment(@PathVariable Long id, @ModelAttribute("payment") PaymentDto payment) {
//        paymentClient.updatePayment(id, payment);
//        return "redirect:/payment/all";
//    }

    @GetMapping("/delete/{id}")
    public String deletePayment(@PathVariable Long id) {
        paymentClient.deletePayment(id);
        return "redirect:/payment/all";
    }

    @GetMapping("/total-revenue")
    public String getTotalRevenue(Model model) {
        model.addAttribute("totalRevenue", paymentClient.getTotalRevenue());
        return "payment/revenue";
    }
}
