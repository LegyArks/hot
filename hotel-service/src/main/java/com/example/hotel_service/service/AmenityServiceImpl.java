package com.example.hotel_service.service;

import com.example.hotel_service.entity.Amenity;
import com.example.hotel_service.entity.Hotel;
import com.example.hotel_service.entity.Room;
import com.example.hotel_service.repository.AmenityRepository;
import com.example.hotel_service.repository.HotelRepository;
import com.example.hotel_service.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmenityServiceImpl implements AmenityService {

    private AmenityRepository amenityRepository;

    private HotelRepository hotelRepository;

    private RoomRepository roomRepository;
    
    @Autowired
    public AmenityServiceImpl(AmenityRepository amenityRepository, HotelRepository hotelRepository,
			RoomRepository roomRepository) {
		super();
		this.amenityRepository = amenityRepository;
		this.hotelRepository = hotelRepository;
		this.roomRepository = roomRepository;
	}

	@Override
    public Amenity addAmenity(Amenity amenity) {
        return amenityRepository.save(amenity);
    }

    @Override
    public List<Amenity> getAllAmenities() {
        return amenityRepository.findAll();
    }

    @Override
    public Amenity getAmenityById(Long amenityId) {
        return amenityRepository.findById(amenityId)
                .orElseThrow(() -> new RuntimeException("Amenity not found with id " + amenityId));
    }

    @Override
    public List<Amenity> getAmenitiesByHotel(Long hotelId) {
        Hotel hotel = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found with id " + hotelId));
        return hotel.getAmenity();
    }

    @Override
    public List<Amenity> getAmenitiesByRoom(Long roomId) {
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RuntimeException("Room not found with id " + roomId));
        return room.getAmenities();
    }

    @Override
    public Amenity updateAmenity(Long amenityId, Amenity amenity) {
        Amenity existing = getAmenityById(amenityId);
        existing.setName(amenity.getName());
        existing.setDescription(amenity.getDescription());
        return amenityRepository.save(existing);
    }

    @Override
    public void deleteAmenity(Long amenityId) {
        amenityRepository.deleteById(amenityId);
    }
}
