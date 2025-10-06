package com.example.hotel_service.entity;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hotelId;

    private String name;
    private String location;
    private String description;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "hotelamenity",
        joinColumns = @JoinColumn(name = "hotel_id"),
        inverseJoinColumns = @JoinColumn(name = "amenity_id")
    )
    
    @JsonIgnore
    private List<Amenity> amenities;

    public Hotel() {}

	public Hotel(Long hotelId, String name, String location, String description,
			List<Amenity> amenities) {
		super();
		this.hotelId = hotelId;
		this.name = name;
		this.location = location;
		this.description = description;
		this.amenities = amenities;
	}

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

	public List<Amenity> getAmenity() {
		return amenities;
	}

	public void setAmenity(List<Amenity> amenities) {
		this.amenities = amenities;
	}

	@Override
	public String toString() {
		return "Hotel [hotelId=" + hotelId + ", name=" + name + ", location=" + location + ", description="
				+ description + "]";
	}
    
    
}
