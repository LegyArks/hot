package com.example.hotel_service.service;

import com.example.hotel_service.entity.RoomType;
import java.util.List;

public interface RoomTypeService {
	
    RoomType addRoomType(RoomType roomType);
    
    RoomType getRoomTypeById(Long roomTypeId);
    
    RoomType updateRoomType(Long roomTypeId, RoomType roomType);
    
    void deleteRoomType(Long roomTypeId);
    
    List<RoomType> getAllRoomTypes();
    
}

