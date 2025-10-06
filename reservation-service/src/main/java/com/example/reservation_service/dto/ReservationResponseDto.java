package com.example.reservation_service.dto;

import com.example.reservation_service.entity.Reservation;
import com.example.reservation_service.entity.Payment;

public class ReservationResponseDto {

    private Reservation reservation;
    private RoomDto room;
    private Payment payment;

    public ReservationResponseDto() {}

    public ReservationResponseDto(Reservation reservation, RoomDto room, Payment payment) {
        this.reservation = reservation;
        this.room = room;
        this.payment = payment;
    }

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public RoomDto getRoom() {
		return room;
	}

	public void setRoom(RoomDto room) {
		this.room = room;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

    
}
