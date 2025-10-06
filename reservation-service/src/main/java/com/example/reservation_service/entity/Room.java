package com.example.reservation_service.entity;

public class Room {
	
	private Long roomId;
    private String roomNumber;
    private boolean isAvailable;
    
	public Room() {
		super();
	}

	public Room(Long roomId, String roomNumber, boolean isAvailable) {
		super();
		this.roomId = roomId;
		this.roomNumber = roomNumber;
		this.isAvailable = isAvailable;
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

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "RoomDto [roomId=" + roomId + ", roomNumber=" + roomNumber + ", isAvailable=" + isAvailable + "]";
	}

	
    

}
