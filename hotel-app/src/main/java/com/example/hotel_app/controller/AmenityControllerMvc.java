package com.example.hotel_app.controller;

import com.example.hotel_app.dto.*;
import com.example.hotel_app.feign.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/amenities")
public class AmenityControllerMvc {

    private final AmenityServiceClient amenityClient;

    public AmenityControllerMvc(AmenityServiceClient amenityClient) {
        this.amenityClient = amenityClient;
    }

    @GetMapping("/all")
    public String getAllAmenities(Model model) {
        model.addAttribute("amenities", amenityClient.getAllAmenities());
        return "amenities/list";
    }

    @GetMapping("/add")
    public String addAmenityForm(Model model) {
        model.addAttribute("amenity", new AmenityDto());
        return "amenities/add";
    }

    @PostMapping("/save")
    public String saveAmenity(@ModelAttribute("amenity") AmenityDto amenity) {
    	amenityClient.createAmenity(amenity);
        return "redirect:/amenities/all";
    }

    @GetMapping("/edit/{id}")
    public String editAmenityForm(@PathVariable Long id, Model model) {
        model.addAttribute("amenity", amenityClient.getAmenityById(id));
        return "amenities/edit";
    }

    @PostMapping("/update/{id}")
    public String updateAmenity(@PathVariable Long id, @ModelAttribute("amenity") AmenityDto amenity) {
    	amenityClient.updateAmenity(id, amenity);
        return "redirect:/amenities/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteAmenity(@PathVariable Long id) {
    	amenityClient.deleteAmenity(id);
        return "redirect:/amenities/all";
    }
}
