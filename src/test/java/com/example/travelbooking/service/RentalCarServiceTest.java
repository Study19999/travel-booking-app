package com.example.travelbooking.service;

import com.example.travelbooking.model.RentalCar;
import com.example.travelbooking.repository.RentalCarRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class RentalCarServiceTest {

    @Autowired
    private RentalCarService rentalCarService;

    @Autowired
    private RentalCarRepository rentalCarRepository;

    @Test
    public void testGetAllRentalCars() {
        // Arrange
        RentalCar rentalCar1 = new RentalCar(1L, "Example Car 1", "Sedan", 5, 50.0);
        RentalCar rentalCar2 = new RentalCar(2L, "Example Car 2", "SUV", 7, 80.0);

        // Save rental cars directly using the real repository
        rentalCarRepository.saveAll(List.of(rentalCar1, rentalCar2));

        // Act
        List<RentalCar> result = rentalCarService.getAllRentalCars();

        // Assert
        assertEquals(2, result.size());
    }
    @Test
    public void testSearchRentalCars() {
        // Arrange
        RentalCar rentalCar1 = new RentalCar(1L, "Example Car 1", "Sedan", 5, 50.0);
        RentalCar rentalCar2 = new RentalCar(2L, "Example Car 2", "SUV", 7, 80.0);

        // Save rental cars directly using the real repository
        rentalCarRepository.saveAll(List.of(rentalCar1, rentalCar2));

        // Act
        List<RentalCar> result = rentalCarService.searchRentalCars(6);

        // Assert
        assertEquals(1, result.size());
        assertEquals("Example Car 2", result.get(0).getBrand());
    }
    @Test
    public void testGetRentalCarById() {
        // Arrange
        RentalCar rentalCar = new RentalCar(1L, "Example Car", "Sedan", 5, 50.0);

        // Save rental car directly using the real repository
        rentalCarRepository.save(rentalCar);

        // Act
        Optional<RentalCar> result = rentalCarService.getRentalCarById(1L);

        // Assert
        assertEquals("Example Car", result.get().getBrand());
    }
    @Test
    public void testSaveRentalCar() {
        // Arrange
        RentalCar rentalCarToSave = new RentalCar(null, "Example Car", "Sedan", 5, 50.0);

        // Act
        RentalCar savedRentalCar = rentalCarService.saveRentalCar(rentalCarToSave);

        // Assert
        assertEquals("Example Car", savedRentalCar.getBrand());
    }
    @Test
    public void testDeleteRentalCar() {
        // Arrange
        RentalCar rentalCarToDelete = new RentalCar(null, "Example Car", "Sedan", 5, 50.0);

        // Save rental car directly using the real repository
        RentalCar savedRentalCar = rentalCarRepository.save(rentalCarToDelete);

        // Act
        rentalCarService.deleteRentalCar(savedRentalCar.getId());

        // Assert
        assertFalse(rentalCarRepository.existsById(savedRentalCar.getId()));
    }
}
