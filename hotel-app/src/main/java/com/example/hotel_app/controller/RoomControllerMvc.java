package com.example.hotel_app.controller;

import com.example.hotel_app.dto.*;
import com.example.hotel_app.feign.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rooms")
public class RoomControllerMvc {

    private final RoomServiceClient roomClient;
    private final HotelServiceClient hotelClient;

    public RoomControllerMvc(RoomServiceClient roomClient, HotelServiceClient hotelClient) {
        this.roomClient = roomClient;
        this.hotelClient = hotelClient;
    }

    @GetMapping("/all")
    public String getAllRooms(Model model) {
        model.addAttribute("rooms", roomClient.getAllRooms());
        return "rooms/list";
    }

    @GetMapping("/add")
    public String addRoomForm(Model model) {
        model.addAttribute("room", new RoomDto());
        model.addAttribute("hotels", roomClient.getAllRooms());
        return "rooms/add";
    }

    @PostMapping("/save")
    public String saveRoom(@ModelAttribute("room") RoomDto room) {
    	roomClient.createRoom(room);
        return "redirect:/rooms/all";
    }

    @GetMapping("/edit/{id}")
    public String editRoomForm(@PathVariable Long id, Model model) {
        model.addAttribute("room", roomClient.getRoomById(id));
        model.addAttribute("hotels", hotelClient.getAllHotels());
        return "rooms/edit";
    }

    @PostMapping("/update/{id}")
    public String updateRoom(@PathVariable Long id, @ModelAttribute("room") RoomDto room) {
    	roomClient.updateRoom(id, room);
        return "redirect:/rooms/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteRoom(@PathVariable Long id) {
    	roomClient.deleteRoom(id);
        return "redirect:/rooms/all";
    }
}
