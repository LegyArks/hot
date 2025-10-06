package com.example.reservation_service.service;


import com.example.reservation_service.entity.Users;
import java.util.List;

public interface UserService {
    Users createUser(Users user);
    
    Users getUser(Long userId);
    
    List<Users> getAllUsers();
    
    Users updateUser(Long userId, Users updatedUser);
    
    void deleteUser(Long userId);
}
