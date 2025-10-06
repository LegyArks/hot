package com.example.reservation_service.dto;

import java.util.List;

public class UserDTO {
	
    private Long userId;
    private String name;
    private String email;
    private String phone;
    private List<ReservationDTO> reservations;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public List<ReservationDTO> getReservations() {
		return reservations;
	}
	public void setReservations(List<ReservationDTO> reservations) {
		this.reservations = reservations;
	}

    
}

