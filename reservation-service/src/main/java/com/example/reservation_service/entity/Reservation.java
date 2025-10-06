package com.example.reservation_service.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;

    private String guestName;
    private String guestEmail;
    private String guestPhone;
    private LocalDate  checkInDate;
    private LocalDate  checkOutDate;

    private Long roomId; // from hotel-service

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties("reservations")
    private Users user;

    public Reservation() {}

	public Long getReservationId() {
		return reservationId;
	}

	public Reservation(Long reservationId, String guestName, String guestEmail, String guestPhone, LocalDate  checkInDate,
			LocalDate  checkOutDate, Long roomId) {
		this.reservationId = reservationId;
		this.guestName = guestName;
		this.guestEmail = guestEmail;
		this.guestPhone = guestPhone;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.roomId = roomId;
	}

	public void setReservationId(Long reservationId) {
		this.reservationId = reservationId;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getGuestEmail() {
		return guestEmail;
	}

	public void setGuestEmail(String guestEmail) {
		this.guestEmail = guestEmail;
	}

	public String getGuestPhone() {
		return guestPhone;
	}

	public void setGuestPhone(String guestPhone) {
		this.guestPhone = guestPhone;
	}

	public LocalDate  getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(LocalDate  checkInDate) {
		this.checkInDate = checkInDate;
	}

	public LocalDate  getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDate  checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", guestName=" + guestName + ", guestEmail=" + guestEmail
				+ ", guestPhone=" + guestPhone + ", checkInDate=" + checkInDate + ", checkOutDate=" + checkOutDate
				+ ", roomId=" + roomId + ", user=" + user + "]";
	}

    
    
    
}
