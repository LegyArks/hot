package com.example.hotel_service.service;

import com.example.hotel_service.entity.Amenity;
import java.util.List;

public interface AmenityService {
	
    Amenity addAmenity(Amenity amenity);
    
    List<Amenity> getAllAmenities();
    
    Amenity getAmenityById(Long amenityId);
    
    List<Amenity> getAmenitiesByHotel(Long hotelId);
    
    List<Amenity> getAmenitiesByRoom(Long roomId);
    
    Amenity updateAmenity(Long amenityId, Amenity amenity);
    
    void deleteAmenity(Long amenityId);
}
