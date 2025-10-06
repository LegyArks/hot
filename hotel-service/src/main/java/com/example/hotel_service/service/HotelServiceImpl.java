package com.example.hotel_service.service;

import com.example.hotel_service.entity.Hotel;
import com.example.hotel_service.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    private HotelRepository hotelRepository;

    @Autowired
    public HotelServiceImpl(HotelRepository hotelRepository) {
		super();
		this.hotelRepository = hotelRepository;
	}

    
    @Override
    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

	@Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(Long hotelId) {
        return hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found with id " + hotelId));
    }

    @Override
    public List<Hotel> getHotelsByAmenity(Long amenityId) {
        return hotelRepository.findByAmenitiesAmenityId(amenityId);
    }

    @Override
    public Hotel updateHotel(Long hotelId, Hotel hotel) {
        Hotel existingHotel = getHotelById(hotelId);
        existingHotel.setName(hotel.getName());
        existingHotel.setLocation(hotel.getLocation());
        existingHotel.setDescription(hotel.getDescription());
        existingHotel.setAmenity(hotel.getAmenity());
        return hotelRepository.save(existingHotel);
    }

    @Override
    public void deleteHotel(Long hotelId) {
        hotelRepository.deleteById(hotelId);
    }
}
