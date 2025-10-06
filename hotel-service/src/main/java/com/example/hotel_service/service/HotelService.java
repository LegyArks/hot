package com.example.hotel_service.service;

import com.example.hotel_service.entity.Hotel;

import java.util.List;

public interface HotelService {
	
    Hotel addHotel(Hotel hotel);
    
    List<Hotel> getAllHotels();
    
    Hotel getHotelById(Long hotelId);
    
    List<Hotel> getHotelsByAmenity(Long amenityId);
    
    Hotel updateHotel(Long hotelId, Hotel hotel);
    
    void deleteHotel(Long hotelId);
}
