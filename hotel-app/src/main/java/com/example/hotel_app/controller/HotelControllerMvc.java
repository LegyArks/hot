package com.example.hotel_app.controller;

import com.example.hotel_app.dto.*;
import com.example.hotel_app.feign.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hotels")
public class HotelControllerMvc {

    private final HotelServiceClient hotelClient;

    public HotelControllerMvc(HotelServiceClient hotelClient) {
        this.hotelClient = hotelClient;
    }

    @GetMapping("/all")
    public String getAllHotels(Model model) {
        model.addAttribute("hotels", hotelClient.getAllHotels());
        return "hotels/list";
    }

    @GetMapping("/add")
    public String addHotelForm(Model model) {
        model.addAttribute("hotel", new HotelDto());
        return "hotels/add";
    }

    @PostMapping("/save")
    public String saveHotel(@ModelAttribute("hotel") HotelDto hotel) {
    	hotelClient.createHotel(hotel);
        return "redirect:/hotels/all";
    }

//    @GetMapping("/edit/{id}")
//    public String editHotelForm(@PathVariable Long id, Model model) {
//        model.addAttribute("hotel", hotelClient.getHotel(id));
//        return "hotels/edit";
//    }

    @PostMapping("/update/{id}")
    public String updateHotel(@PathVariable Long id, @ModelAttribute("hotel") HotelDto hotel) {
    	hotelClient.updateHotel(id, hotel);
        return "redirect:/hotels/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteHotel(@PathVariable Long id) {
    	hotelClient.deleteHotel(id);
        return "redirect:/hotels/all";
    }
}
