package com.example.hotel_app.feign;
import com.example.hotel_app.dto.RoomDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@FeignClient(name = "room-service", url = "http://localhost:8082")
public interface RoomServiceClient {

    @PostMapping("/api/room/post")
    RoomDto createRoom(@RequestBody RoomDto room);

    @GetMapping("/api/room/all")
    List<RoomDto> getAllRooms();

    @GetMapping("/api/room/{roomId}")
    RoomDto getRoomById(@PathVariable("roomId") Long roomId);

    @GetMapping("/api/room/available/{roomTypeId}")
    List<RoomDto> getAvailableRoomsByType(@PathVariable("roomTypeId") Long roomTypeId);

    @GetMapping("/api/room/location/{location}")
    List<RoomDto> getRoomsByLocation(@PathVariable("location") String location);

    @GetMapping("/api/room/amenities/{amenityId}")
    List<RoomDto> getRoomsByAmenity(@PathVariable("amenityId") Long amenityId);

    @PutMapping("/api/room/put/{roomId}")
    RoomDto updateRoom(@PathVariable("roomId") Long roomId, @RequestBody RoomDto room);

    @DeleteMapping("/api/room/delete/{roomId}")
    void deleteRoom(@PathVariable("roomId") Long roomId);
}
