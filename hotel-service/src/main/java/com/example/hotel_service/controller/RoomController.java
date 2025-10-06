package com.example.hotel_service.controller;

import com.example.hotel_service.entity.Room;
import com.example.hotel_service.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room")
public class RoomController {

	private RoomService roomService;
    
	@Autowired
    public RoomController(RoomService roomService) {
		super();
		this.roomService = roomService;
	}

	@PostMapping("/post")
    public ResponseEntity<Object> addRoom(@RequestBody Room room) {
        Room newRoom = roomService.addRoom(room);
        return new ResponseEntity<>(newRoom, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllRooms() {
        List<Room> rooms = roomService.getAllRooms();
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/{roomId}")
    public ResponseEntity<Object> getRoomById(@PathVariable Long roomId) {
        Room room = roomService.getRoomById(roomId);
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @GetMapping("/available/{roomTypeId}")
    public ResponseEntity<Object> getAvailableRoomsByType(@PathVariable Long roomTypeId) {
        List<Room> rooms = roomService.getRoomsByRoomType(roomTypeId);
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<Object> getRoomsByLocation(@PathVariable String location) {
        List<Room> rooms = roomService.getRoomsByLocation(location);
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @GetMapping("/amenities/{amenityId}")
    public ResponseEntity<Object> getRoomsByAmenity(@PathVariable Long amenityId) {
        List<Room> rooms = roomService.getRoomsByAmenity(amenityId);
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @PutMapping("/put/{roomId}")
    public ResponseEntity<Object> updateRoom(@PathVariable Long roomId, @RequestBody Room room) {
        Room updatedRoom = roomService.updateRoom(roomId, room);
        return new ResponseEntity<>(updatedRoom, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{roomId}")
    public ResponseEntity<Object> deleteRoom(@PathVariable Long roomId) {
        roomService.deleteRoom(roomId);
        return new ResponseEntity<>("Room deleted successfully", HttpStatus.OK);
    }
}
