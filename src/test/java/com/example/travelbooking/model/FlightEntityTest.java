package com.example.travelbooking.model;

import com.example.travelbooking.model.Flight;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class FlightEntityTest {

    @Test
    public void testFlightEntity() {
        Flight flight = new Flight();
        flight.setId(1L);
        flight.setAirline("Cathay Pacific");
        flight.setOrigin("Doha");
        flight.setDestination("Amsterdam");
        flight.setDepartureTime(LocalDateTime.parse("2023-12-03T10:15:30"));
        flight.setArrivalTime(LocalDateTime.parse("2023-12-03T10:23:30"));
        flight.setPrice(2000.0);

        assertEquals(1L, flight.getId());
        assertEquals("Cathay Pacific", flight.getAirline());
        assertEquals("Doha", flight.getOrigin());
        assertEquals("Amsterdam", flight.getDestination());
        assertEquals(LocalDateTime.parse("2023-12-03T10:15:30"), flight.getDepartureTime());
        assertEquals(LocalDateTime.parse("2023-12-03T10:23:30"), flight.getArrivalTime());
        assertEquals(2000.0, flight.getPrice(), 0.01);
    }
    @Test
    public void testAllArgsConstructor() {
        LocalDateTime departureTime = LocalDateTime.parse("2023-12-03T10:15:30");
        LocalDateTime arrivalTime = LocalDateTime.parse("2023-12-03T10:23:30");

        Flight flight = new Flight(1L, "Cathay Pacific", "Doha", "Amsterdam", departureTime, arrivalTime, 2000.0);

        assertEquals(1L, flight.getId());
        assertEquals("Cathay Pacific", flight.getAirline());
        assertEquals("Doha", flight.getOrigin());
        assertEquals("Amsterdam", flight.getDestination());
        assertEquals(departureTime, flight.getDepartureTime());
        assertEquals(arrivalTime, flight.getArrivalTime());
        assertEquals(2000.0, flight.getPrice(), 0.01);
    }
}