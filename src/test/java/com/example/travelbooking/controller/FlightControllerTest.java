package com.example.travelbooking.controller;

import com.example.travelbooking.model.Flight;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDateTime;

@SpringBootTest
@AutoConfigureMockMvc
public class FlightControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testAddFlight() throws Exception {
        // Arrange
        String flightJson = "{\"airline\":\"Cathay Pacific\",\"origin\":\"Doha\",\"destination\":\"Amsterdam\",\"departureTime\":\"2023-12-03T10:15:30\",\"arrivalTime\":\"2023-12-03T10:23:30\",\"price\":2000.0}";

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/flights/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(flightJson))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void testSearchFlights() throws Exception {
        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/flights/search")
                        .param("origin", "Doha")
                        .param("destination", "Amsterdam")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void testGetAllFlights() throws Exception {
        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/flights/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void testGetFlightById() throws Exception {
        // Replace {flightId} with an existing flight ID in your database
        long flightId = 1L;

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/flights/{flightId}", flightId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void testUpdateFlight() throws Exception {
        long flightId = 1L;

        Flight updatedFlight = new Flight();
        updatedFlight.setId(flightId);
        updatedFlight.setAirline("Updated Airline");
        updatedFlight.setOrigin("Updated Origin");
        updatedFlight.setDestination("Updated Destination");
        updatedFlight.setDepartureTime(LocalDateTime.parse("2023-12-03T12:00:00"));
        updatedFlight.setArrivalTime(LocalDateTime.parse("2023-12-03T15:00:00"));
        updatedFlight.setPrice(2500.0);

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.put("/flights/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedFlight)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void testDeleteFlight() throws Exception {
        // Replace {flightId} with an existing flight ID in your database
        long flightId = 1L;

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.delete("/flights/delete/{id}", flightId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
