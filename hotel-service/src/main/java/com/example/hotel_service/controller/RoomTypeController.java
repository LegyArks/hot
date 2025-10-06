package com.example.hotel_service.controller;

import com.example.hotel_service.entity.RoomType;

import com.example.hotel_service.service.RoomTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/RoomType")
public class RoomTypeController {
 
    private RoomTypeService roomTypeService;
    
    @Autowired
    public RoomTypeController(RoomTypeService roomTypeService) {
		super();
		this.roomTypeService = roomTypeService;
	}

	@PostMapping("/post")
    public ResponseEntity<Object> addRoomType(@RequestBody RoomType roomType) {
        RoomType newRoomType = roomTypeService.addRoomType(roomType);
        return new ResponseEntity<>(newRoomType, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getAllRoomtypes() {
        List<RoomType> roomTypes = roomTypeService.getAllRoomTypes();
        return new ResponseEntity<>(roomTypes, HttpStatus.OK);
    }

    @GetMapping("/{roomTypeId}")
    public ResponseEntity<Object> getRoomTypeById(@PathVariable Long roomTypeId) {
        RoomType roomType = roomTypeService.getRoomTypeById(roomTypeId);
        return new ResponseEntity<>(roomType, HttpStatus.OK);
    }

    @PutMapping("/update/{roomTypeId}")
    public ResponseEntity<Object> updateRoomType(@PathVariable Long roomTypeId, @RequestBody RoomType roomType) {
        RoomType updatedRoomType = roomTypeService.updateRoomType(roomTypeId, roomType);
        return new ResponseEntity<>(updatedRoomType, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{roomTypeId}")
    public ResponseEntity<Object> deleteRoomtype(@PathVariable Long roomTypeId) {
        roomTypeService.deleteRoomType(roomTypeId);
        return new ResponseEntity<>("RoomType deleted successfully", HttpStatus.OK);
    }
}
