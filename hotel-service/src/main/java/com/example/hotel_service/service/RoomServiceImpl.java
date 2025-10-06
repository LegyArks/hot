package com.example.hotel_service.service;

import com.example.hotel_service.entity.Room;
import com.example.hotel_service.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;
    
    @Autowired
    public RoomServiceImpl(RoomRepository roomRepository) {
		super();
		this.roomRepository = roomRepository;
	}

	@Override
    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room getRoomById(Long roomId) {
        return roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found with id " + roomId));
    }

    @Override
    public List<Room> getRoomsByRoomType(Long roomTypeId) {
        return roomRepository.findByRoomTypeRoomTypeId(roomTypeId);
    }

    @Override
    public List<Room> getRoomsByLocation(String location) {
        return roomRepository.findByHotelLocation(location);
    }

    @Override
    public List<Room> getRoomsByAmenity(Long amenityId) {
        return roomRepository.findByAmenitiesAmenityId(amenityId);
    }

    @Override
    public Room updateRoom(Long roomId, Room room) {
        Room existingRoom = getRoomById(roomId);
        existingRoom.setRoomNumber(room.getRoomNumber());
        existingRoom.setPrice(room.getPrice());
        existingRoom.setHotel(room.getHotel());
        existingRoom.setRoomtype(room.getRoomtype());
        existingRoom.setAmenities(room.getAmenities());
        return roomRepository.save(existingRoom);
    }

    @Override
    public void deleteRoom(Long roomId) {
        roomRepository.deleteById(roomId);
    }
}
