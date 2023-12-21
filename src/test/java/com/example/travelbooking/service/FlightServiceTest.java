package com.example.travelbooking.service;

import com.example.travelbooking.model.Flight;
import com.example.travelbooking.repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class FlightServiceTest {

    @Autowired
    private FlightService flightService;

    @Autowired
    private FlightRepository flightRepository;

    @Test
    public void testGetAllFlights() {
        // Arrange
        Flight flight1 = new Flight(1L, "Cathay Pacific", "Doha", "Amsterdam",
                LocalDateTime.parse("2023-12-03T10:15:30"), LocalDateTime.parse("2023-12-03T10:23:30"), 2000.0);
        Flight flight2 = new Flight(2L, "Emirates", "Dubai", "New York",
                LocalDateTime.parse("2023-12-03T12:30:00"), LocalDateTime.parse("2023-12-03T18:45:00"), 2500.0);

        // Save flights directly using the real repository
        flightRepository.saveAll(List.of(flight1, flight2));

        // Act
        List<Flight> result = flightService.getAllFlights();

        // Assert
        assertEquals(2, result.size());
    }

    @Test
    public void testSearchFlights() {
        // Arrange
        Flight flight1 = new Flight(1L, "Cathay Pacific", "Doha", "Amsterdam",
                LocalDateTime.parse("2023-12-03T10:15:30"), LocalDateTime.parse("2023-12-03T10:23:30"), 2000.0);
        Flight flight2 = new Flight(2L, "Emirates", "Dubai", "New York",
                LocalDateTime.parse("2023-12-03T12:30:00"), LocalDateTime.parse("2023-12-03T18:45:00"), 2500.0);

        // Save flights directly using the real repository
        flightRepository.saveAll(List.of(flight1, flight2));

        // Act
        List<Flight> result = flightService.searchFlights("Doha", "Amsterdam");

        // Assert
        assertEquals(1, result.size());
        assertEquals("Cathay Pacific", result.get(0).getAirline());
    }
    @Test
    public void testGetFlightById() {
        // Arrange
        Flight flight = new Flight(1L, "Cathay Pacific", "Doha", "Amsterdam",
                LocalDateTime.parse("2023-12-03T10:15:30"), LocalDateTime.parse("2023-12-03T10:23:30"), 2000.0);

        // Save flight directly using the real repository
        flightRepository.save(flight);

        // Act
        Optional<Flight> result = flightService.getFlightById(1L);

        // Assert
        assertEquals("Cathay Pacific", result.get().getAirline());
    }
    @Test
    public void testSaveFlight() {
        // Arrange
        Flight flightToSave = new Flight(null, "Cathay Pacific", "Doha", "Amsterdam",
                LocalDateTime.parse("2023-12-03T10:15:30"), LocalDateTime.parse("2023-12-03T10:23:30"), 2000.0);

        // Act
        Flight savedFlight = flightService.saveFlight(flightToSave);

        // Assert
        assertEquals("Cathay Pacific", savedFlight.getAirline());
    }
    @Test
    public void testDeleteFlight() {
        // Arrange
        Flight flightToDelete = new Flight(null, "Cathay Pacific", "Doha", "Amsterdam",
                LocalDateTime.parse("2023-12-03T10:15:30"), LocalDateTime.parse("2023-12-03T10:23:30"), 2000.0);

        // Save flight directly using the real repository
        Flight savedFlight = flightRepository.save(flightToDelete);

        // Act
        flightService.deleteFlight(savedFlight.getId());

        // Assert
        assertFalse(flightRepository.existsById(savedFlight.getId()));
    }
}
