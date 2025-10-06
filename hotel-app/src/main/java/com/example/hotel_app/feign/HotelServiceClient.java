package com.example.hotel_app.feign;

import com.example.hotel_app.dto.HotelDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@FeignClient(name = "hotel-service", url = "http://localhost:8082")
public interface HotelServiceClient {

    @PostMapping("/api/hotels/post")
    HotelDto createHotel(@RequestBody HotelDto hotel);

    @GetMapping("/api/hotels/all")
    List<HotelDto> getAllHotels();

    @GetMapping("/api/hotels/hotels/{hotelId}")
    HotelDto getHotelById(@PathVariable("hotelId") Long hotelId);

    @GetMapping("/api/hotels/amenity_id/{amenityId}")
    List<HotelDto> getHotelsByAmenity(@PathVariable("amenityId") Long amenityId);

    @PutMapping("/api/hotels/update/{hotelId}")
    HotelDto updateHotel(@PathVariable("hotelId") Long hotelId, @RequestBody HotelDto hotel);

    @DeleteMapping("/api/hotels/delete/{hotelId}")
    void deleteHotel(@PathVariable("hotelId") Long hotelId);
}
