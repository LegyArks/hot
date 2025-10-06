package com.example.hotel_app.feign;

import com.example.hotel_app.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@FeignClient(name = "reservation-service", url = "http://localhost:8081/api/users")
public interface UserServiceClient {

    @PostMapping("/post")
    UserDto createUser(@RequestBody UserDto user);

    @GetMapping("/all")
    List<UserDto> getAllUsers();

    @GetMapping("/{userId}")
    UserDto getUser(@PathVariable("userId") Long userId);

    @PutMapping("/update/{userId}")
    UserDto updateUser(@PathVariable("userId") Long userId, @RequestBody UserDto user);

    @DeleteMapping("/delete/{userId}")
    void deleteUser(@PathVariable("userId") Long userId);
}
