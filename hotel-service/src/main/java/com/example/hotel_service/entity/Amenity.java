package com.example.hotel_service.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "amenity")
public class Amenity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long amenityId;

    private String name;

    private String description;
    
    public Amenity() {}

	public Amenity(Long amenityId, String name, String description) {
		super();
		this.amenityId = amenityId;
		this.name = name;
		this.description = description;
	}

	public Long getAmenityId() {
		return amenityId;
	}

	public void setAmenityId(Long amenityId) {
		this.amenityId = amenityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    

    
    // getters and setters
}
