package com.example.hotel_app.dto;

import java.util.List;

public class RoomDto {
    private Long roomId;
    
    private String roomNumber;
    
    private Double price;
    
    private Long hotelId;
    
    private Long roomTypeId;
    
    private List<AmenityDto> amenities;

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public Long getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(Long roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public List<AmenityDto> getAmenities() {
		return amenities;
	}

	public void setAmenities(List<AmenityDto> amenities) {
		this.amenities = amenities;
	}
    
}
