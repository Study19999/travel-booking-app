package com.example.travelbooking.controller;

import com.example.travelbooking.model.RentalCar;
import com.example.travelbooking.service.RentalCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rental-cars")
public class RentalCarController {

    @Autowired
    private RentalCarService rentalCarService;

    @GetMapping("/search")
    public List<RentalCar> searchRentalCars(@RequestParam int capacity) {
        return rentalCarService.searchRentalCars(capacity);
    }

    @GetMapping("/all")
    public List<RentalCar> getAllRentalCars() {
        return rentalCarService.getAllRentalCars();
    }

    @GetMapping("/{id}")
    public Optional<RentalCar> getRentalCarById(@PathVariable Long id) {
        return rentalCarService.getRentalCarById(id);
    }

    @PostMapping("/add")
    public RentalCar addRentalCar(@RequestBody RentalCar rentalCar) {
        return rentalCarService.saveRentalCar(rentalCar);
    }

    @PutMapping("/update")
    public RentalCar updateRentalCar(@RequestBody RentalCar rentalCar) {
        return rentalCarService.saveRentalCar(rentalCar);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRentalCar(@PathVariable Long id) {
        rentalCarService.deleteRentalCar(id);
    }
}