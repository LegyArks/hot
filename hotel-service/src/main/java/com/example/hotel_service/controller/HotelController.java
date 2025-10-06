package com.example.hotel_service.controller;

import com.example.hotel_service.entity.Hotel;
import com.example.hotel_service.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    private HotelService hotelService;
    
    @Autowired
    public HotelController(HotelService hotelService) {
		super();
		this.hotelService = hotelService;
	}

    @PostMapping("/post")
    public ResponseEntity<Object> addHotel(@RequestBody Hotel hotel) {
        Hotel newHotel = hotelService.addHotel(hotel);
        return new ResponseEntity<>(newHotel, HttpStatus.CREATED);
    }

	@GetMapping("/all")
    public ResponseEntity<Object> getAllHotels() {
        List<Hotel> hotels = hotelService.getAllHotels();
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<Object> getHotelById(@PathVariable Long hotelId) {
        Hotel hotel = hotelService.getHotelById(hotelId);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }

    @GetMapping("/amenity_id/{amenityId}")
    public ResponseEntity<Object> getHotelsByAmenity(@PathVariable Long amenityId) {
        List<Hotel> hotels = hotelService.getHotelsByAmenity(amenityId);
        return new ResponseEntity<>(hotels, HttpStatus.OK);
    }

    @PutMapping("/update/{hotelId}")
    public ResponseEntity<Object> updateHotel(@PathVariable Long hotelId, @RequestBody Hotel hotel) {
        Hotel updatedHotel = hotelService.updateHotel(hotelId, hotel);
        return new ResponseEntity<>(updatedHotel, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{hotelId}")
    public ResponseEntity<Object> deleteHotel(@PathVariable Long hotelId) {
        hotelService.deleteHotel(hotelId);
        return new ResponseEntity<>("Hotel deleted successfully", HttpStatus.OK);
    }
}
