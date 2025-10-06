package com.example.hotel_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.hotel_service.entity.Room;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    // All rooms of a specific room type
    List<Room> findByRoomTypeRoomTypeId(Long roomTypeId);

    // Retrieve rooms by hotel location
    List<Room> findByHotelLocation(String location);

    // Retrieve rooms that have a specific amenity
    List<Room> findByAmenitiesAmenityId(Long amenityId);
}
