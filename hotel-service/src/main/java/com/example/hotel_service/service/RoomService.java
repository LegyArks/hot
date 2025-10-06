package com.example.hotel_service.service;

import com.example.hotel_service.entity.Room;
import java.util.List;

public interface RoomService {
	
    Room addRoom(Room room);
    
    List<Room> getAllRooms();
    
    Room getRoomById(Long roomId);
    
    List<Room> getRoomsByRoomType(Long roomTypeId);
    
    List<Room> getRoomsByLocation(String location);
    
    List<Room> getRoomsByAmenity(Long amenityId);
    
    Room updateRoom(Long roomId, Room room);
    
    void deleteRoom(Long roomId);
}
