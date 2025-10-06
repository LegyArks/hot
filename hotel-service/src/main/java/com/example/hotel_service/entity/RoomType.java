package com.example.hotel_service.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "roomtype")
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomTypeId;

    private String typeName;
    
    private String description;
    
    private int maxOccupancy;
    
    private double pricePerNight;

    public RoomType() {}

	public RoomType(Long roomTypeId, String typeName, String description, int maxOccupancy, double pricePerNight) {
		super();
		this.roomTypeId = roomTypeId;
		this.typeName = typeName;
		this.description = description;
		this.maxOccupancy = maxOccupancy;
		this.pricePerNight = pricePerNight;
	}

	public Long getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(Long roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMaxOccupancy() {
		return maxOccupancy;
	}

	public void setMaxOccupancy(int maxOccupancy) {
		this.maxOccupancy = maxOccupancy;
	}

	public double getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
    
    

    
}
