package com.example.hotel_app.feign;

import com.example.hotel_app.dto.AmenityDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@FeignClient(name = "amenity-service", url = "http://localhost:8082")
public interface AmenityServiceClient {

    @PostMapping("/api/amenity/post")
    AmenityDto createAmenity(@RequestBody AmenityDto amenity);

    @GetMapping("/api/amenity/all")
    List<AmenityDto> getAllAmenities();

    @GetMapping("/api/amenity/{amenityId}")
    AmenityDto getAmenityById(@PathVariable("amenityId") Long amenityId);

    @GetMapping("/api/amenity/hotel/{hotelId}")
    List<AmenityDto> getAmenitiesByHotel(@PathVariable("hotelId") Long hotelId);

    @GetMapping("/api/amenity/room/{roomId}")
    List<AmenityDto> getAmenitiesByRoom(@PathVariable("roomId") Long roomId);

    @PutMapping("/api/amenity/update/{amenityId}")
    AmenityDto updateAmenity(@PathVariable("amenityId") Long amenityId, @RequestBody AmenityDto amenity);

    @DeleteMapping("/api/amenity/delete/{amenityId}")
    void deleteAmenity(@PathVariable("amenityId") Long amenityId);
}
