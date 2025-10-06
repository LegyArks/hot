package com.example.reservation_service.service;

import com.example.reservation_service.entity.Users;
import com.example.reservation_service.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Users createUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public Users getUser(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id " + userId));
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users updateUser(Long userId, Users updatedUser) {
        Users existing = getUser(userId);
        existing.setUserName(updatedUser.getUserName());
        existing.setUserEmail(updatedUser.getUserEmail());
        existing.setUserPassword(updatedUser.getUserPassword());
        existing.setUserPhone(updatedUser.getUserPhone());
        return userRepository.save(existing);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
