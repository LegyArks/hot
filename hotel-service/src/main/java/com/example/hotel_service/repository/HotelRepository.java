package com.example.hotel_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hotel_service.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

	List<Hotel> findByAmenitiesAmenityId(Long amenityId);
	
}
