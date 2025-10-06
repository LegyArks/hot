package com.example.hotel_service.controller;

import com.example.hotel_service.entity.Amenity;
import com.example.hotel_service.service.AmenityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/amenity")
public class AmenityController {

    private AmenityService amenityService;
 
    @Autowired
    public AmenityController(AmenityService amenityService) {
		super();
		this.amenityService = amenityService;
	}

	@PostMapping("/post")
    public ResponseEntity<Object> addAmenity(@RequestBody Amenity amenity) {
        Amenity newAmenity = amenityService.addAmenity(amenity);
        return new ResponseEntity<>(newAmenity, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllAmenities() {
        List<Amenity> amenities = amenityService.getAllAmenities();
        return new ResponseEntity<>(amenities, HttpStatus.OK);
    }

    @GetMapping("/{amenityId}")
    public ResponseEntity<Object> getAmenityById(@PathVariable Long amenityId) {
        Amenity amenity = amenityService.getAmenityById(amenityId);
        return new ResponseEntity<>(amenity, HttpStatus.OK);
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<Object> getAmenitiesByHotel(@PathVariable Long hotelId) {
        List<Amenity> amenities = amenityService.getAmenitiesByHotel(hotelId);
        return new ResponseEntity<>(amenities, HttpStatus.OK);
    }

    @GetMapping("/room/{roomId}")
    public ResponseEntity<Object> getAmenitiesByRoom(@PathVariable Long roomId) {
        List<Amenity> amenities = amenityService.getAmenitiesByRoom(roomId);
        return new ResponseEntity<>(amenities, HttpStatus.OK);
    }

    @PutMapping("/update/{amenityId}")
    public ResponseEntity<Object> updateAmenity(@PathVariable Long amenityId, @RequestBody Amenity amenity) {
        Amenity updatedAmenity = amenityService.updateAmenity(amenityId, amenity);
        return new ResponseEntity<>(updatedAmenity, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{amenityId}")
    public ResponseEntity<Object> deleteAmenity(@PathVariable Long amenityId) {
        amenityService.deleteAmenity(amenityId);
        return new ResponseEntity<>("Amenity deleted successfully", HttpStatus.OK);
    }
}
