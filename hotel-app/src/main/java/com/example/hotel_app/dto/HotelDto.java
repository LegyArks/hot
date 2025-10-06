package com.example.hotel_app.dto;

import java.util.List;

public class HotelDto {
	

	private Long hotelId;
    
    private String name;
    
    private String location;
    
    private String description;
    
    private List<AmenityDto> amenities;
    
    
	
    public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<AmenityDto> getAmenities() {
		return amenities;
	}

	public void setAmenities(List<AmenityDto> amenities) {
		this.amenities = amenities;
	}

    
    
    
}
