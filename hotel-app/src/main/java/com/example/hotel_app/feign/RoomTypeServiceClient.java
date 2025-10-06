package com.example.hotel_app.feign;


import com.example.hotel_app.dto.RoomTypeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@FeignClient(name = "hotel-service-roomtype", url = "http://localhost:8082")
public interface RoomTypeServiceClient {

    @PostMapping("/api/RoomType/post")
    RoomTypeDto createRoomType(@RequestBody RoomTypeDto rt);

    @GetMapping("/api/RoomType/all")
    List<RoomTypeDto> getAllRoomTypes();

    @GetMapping("/api/RoomType/{roomTypeId}")
    RoomTypeDto getRoomTypeById(@PathVariable("roomTypeId") Long roomTypeId);

    @PutMapping("/api/RoomType/update/{roomTypeId}")
    RoomTypeDto updateRoomType(@PathVariable("roomTypeId") Long roomTypeId, @RequestBody RoomTypeDto rt);

    @DeleteMapping("/api/RoomType/delete/{roomTypeId}")
    void deleteRoomType(@PathVariable("roomTypeId") Long roomTypeId);
}
