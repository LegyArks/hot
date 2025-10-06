package com.example.hotel_service.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;

    private String roomNumber;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "roomamenity",
        joinColumns = @JoinColumn(name = "room_id"),
        inverseJoinColumns = @JoinColumn(name = "amenity_id")
    )
    private List<Amenity> amenities;

    public Room() {}

	public Room(Long roomId, String roomNumber, Double price) {
		super();
		this.roomId = roomId;
		this.roomNumber = roomNumber;
		this.price = price;
	}

	public Room(Long roomId, String roomNumber, Double price, Hotel hotel, RoomType roomType, List<Amenity> amenities) {
		super();
		this.roomId = roomId;
		this.roomNumber = roomNumber;
		this.price = price;
		this.hotel = hotel;
		this.roomType = roomType;
		this.amenities = amenities;
	}



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

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public RoomType getRoomtype() {
		return roomType;
	}

	public void setRoomtype(RoomType roomType) {
		this.roomType = roomType;
	}

	public List<Amenity> getAmenities() {
		return amenities;
	}

	public void setAmenities(List<Amenity> amenities) {
		this.amenities = amenities;
	}

    // getters and setters
   
    
}
