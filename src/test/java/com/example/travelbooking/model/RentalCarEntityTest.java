package com.example.travelbooking.model;

import com.example.travelbooking.model.RentalCar;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class RentalCarEntityTest {

    @Test
    public void testRentalCarEntity() {
        RentalCar rentalCar = new RentalCar();
        rentalCar.setId(1L);
        rentalCar.setBrand("Example Brand");
        rentalCar.setModel("Sedan");
        rentalCar.setCapacity(5);
        rentalCar.setDailyRate(50.0);

        assertEquals(1L, rentalCar.getId());
        assertEquals("Example Brand", rentalCar.getBrand());
        assertEquals("Sedan", rentalCar.getModel());
        assertEquals(5, rentalCar.getCapacity());
        assertEquals(50.0, rentalCar.getDailyRate(), 0.01);
    }

    @Test
    public void testAllArgsConstructor() {
        RentalCar rentalCar = new RentalCar(1L, "Example Brand", "Sedan", 5, 50.0);

        assertEquals(1L, rentalCar.getId());
        assertEquals("Example Brand", rentalCar.getBrand());
        assertEquals("Sedan", rentalCar.getModel());
        assertEquals(5, rentalCar.getCapacity());
        assertEquals(50.0, rentalCar.getDailyRate(), 0.01);
    }
}