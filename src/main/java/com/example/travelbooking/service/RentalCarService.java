package com.example.travelbooking.service;

import com.example.travelbooking.model.RentalCar;
import com.example.travelbooking.repository.RentalCarRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RentalCarService {

    private final RentalCarRepository rentalCarRepository;
    public List<RentalCar> searchRentalCars(int capacity) {
        return rentalCarRepository.findByCapacityGreaterThanEqual(capacity);
    }

    public List<RentalCar> getAllRentalCars() {
        return rentalCarRepository.findAll();
    }

    public Optional<RentalCar> getRentalCarById(Long id) {
        return rentalCarRepository.findById(id);
    }

    public RentalCar saveRentalCar(RentalCar rentalCar) {
        return rentalCarRepository.save(rentalCar);
    }

    public void deleteRentalCar(Long id) {
        rentalCarRepository.deleteById(id);
    }
}
