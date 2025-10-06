package com.example.hotel_service.service;

import com.example.hotel_service.entity.RoomType;
import com.example.hotel_service.repository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeServiceImpl implements RoomTypeService {

    private RoomTypeRepository roomTypeRepository;
    
    @Autowired
    public RoomTypeServiceImpl(RoomTypeRepository roomTypeRepository) {
		super();
		this.roomTypeRepository = roomTypeRepository;
	}

	@Override
    public RoomType addRoomType(RoomType roomType) {
        return roomTypeRepository.save(roomType);
    }

    @Override
    public RoomType getRoomTypeById(Long roomTypeId) {
        return roomTypeRepository.findById(roomTypeId)
                .orElseThrow(() -> new RuntimeException("RoomType not found with id " + roomTypeId));
    }

    @Override
    public RoomType updateRoomType(Long roomTypeId, RoomType roomType) {
        RoomType existing = getRoomTypeById(roomTypeId);
        existing.setTypeName(roomType.getTypeName());
        existing.setDescription(roomType.getDescription());
        existing.setMaxOccupancy(roomType.getMaxOccupancy());
        existing.setPricePerNight(roomType.getPricePerNight());
        return roomTypeRepository.save(existing);
    }

    @Override
    public void deleteRoomType(Long roomTypeId) {
        roomTypeRepository.deleteById(roomTypeId);
    }

    @Override
    public List<RoomType> getAllRoomTypes() {
        return roomTypeRepository.findAll();
    }
}
