package com.example.travelbooking.repository;

import com.example.travelbooking.model.RentalCar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalCarRepository extends JpaRepository<RentalCar, Long> {
    List<RentalCar> findByCapacityGreaterThanEqual(int capacity);
}
