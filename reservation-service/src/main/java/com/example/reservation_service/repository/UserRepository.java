package com.example.reservation_service.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.reservation_service.entity.*;

public interface UserRepository extends JpaRepository<Users, Long> { }
