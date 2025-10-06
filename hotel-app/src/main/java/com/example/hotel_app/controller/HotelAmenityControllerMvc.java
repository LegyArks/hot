package com.example.hotel_app.controller;

import com.example.hotel_app.dto.*;
import com.example.hotel_app.feign.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hotel-amenities")
public class HotelAmenityControllerMvc {

//    private final HotelAmenityService hotelAmenityService;
//    private final HotelService hotelService;
//    private final AmenityService amenityService;
//
//    public HotelAmenityControllerMvc(HotelAmenityService hotelAmenityService, HotelService hotelService, AmenityService amenityService) {
//        this.hotelAmenityService = hotelAmenityService;
//        this.hotelService = hotelService;
//        this.amenityService = amenityService;
//    }
//
//    @GetMapping("/all")
//    public String getAllHotelAmenities(Model model) {
//        model.addAttribute("hotelAmenities", hotelAmenityService.getAllHotelAmenities());
//        return "hotel-amenities/list";
//    }
//
//    @GetMapping("/add")
//    public String addHotelAmenityForm(Model model) {
//        model.addAttribute("hotelAmenity", new HotelAmenityDto());
//        model.addAttribute("hotels", hotelService.getAllHotels());
//        model.addAttribute("amenities", amenityService.getAllAmenities());
//        return "hotel-amenities/add";
//    }
//
//    @PostMapping("/save")
//    public String saveHotelAmenity(@ModelAttribute("hotelAmenity") HotelAmenityDto hotelAmenity) {
//        hotelAmenityService.createHotelAmenity(hotelAmenity);
//        return "redirect:/hotel-amenities/all";
//    }
//
//    @GetMapping("/edit/{id}")
//    public String editHotelAmenityForm(@PathVariable Long id, Model model) {
//        model.addAttribute("hotelAmenity", hotelAmenityService.getHotelAmenity(id));
//        model.addAttribute("hotels", hotelService.getAllHotels());
//        model.addAttribute("amenities", amenityService.getAllAmenities());
//        return "hotel-amenities/edit";
//    }
//
//    @PostMapping("/update/{id}")
//    public String updateHotelAmenity(@PathVariable Long id, @ModelAttribute("hotelAmenity") HotelAmenityDto hotelAmenity) {
//        hotelAmenityService.updateHotelAmenity(id, hotelAmenity);
//        return "redirect:/hotel-amenities/all";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteHotelAmenity(@PathVariable Long id) {
//        hotelAmenityService.deleteHotelAmenity(id);
//        return "redirect:/hotel-amenities/all";
//    }
//}
}