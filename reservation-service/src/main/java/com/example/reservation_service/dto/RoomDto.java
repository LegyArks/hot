package com.example.reservation_service.dto;

public class RoomDto {

    private Long roomId;
    private Long roomNumber;
    private Boolean isAvailable;
    private String roomTypeName;
    private Double pricePerNight;

    public RoomDto() {} 

    public RoomDto(Long roomId, Long roomNumber, Boolean isAvailable, String roomTypeName, Double pricePerNight) {
		super();
		this.roomId = roomId;
		this.roomNumber = roomNumber;
		this.isAvailable = isAvailable;
		this.roomTypeName = roomTypeName;
		this.pricePerNight = pricePerNight;
	}

	public Long getRoomId() {
		return roomId;
	}



	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}



	public Long getRoomNumber() {
		return roomNumber;
	}



	public void setRoomNumber(Long roomNumber) {
		this.roomNumber = roomNumber;
	}



	public Boolean getIsAvailable() {
		return isAvailable;
	}



	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}



	public String getRoomTypeName() {
		return roomTypeName;
	}



	public void setRoomTypeName(String roomTypeName) {
		this.roomTypeName = roomTypeName;
	}



	public Double getPricePerNight() {
		return pricePerNight;
	}



	public void setPricePerNight(Double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	@Override
	public String toString() {
		return "RoomDto [roomId=" + roomId + ", roomNumber=" + roomNumber + ", isAvailable=" + isAvailable
				+ ", roomTypeName=" + roomTypeName + ", pricePerNight=" + pricePerNight + "]";
	}
    
}
