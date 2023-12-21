package com.example.travelbooking.controller;

import com.example.travelbooking.model.RentalCar;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class RentalCarControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testAddRentalCar() throws Exception {
        // Arrange
        String rentalCarJson = "{\"brand\":\"Example Car\",\"type\":\"Sedan\",\"capacity\":5,\"pricePerDay\":50.0}";

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/rental-cars/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(rentalCarJson))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testSearchRentalCars() throws Exception {
        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/rental-cars/search")
                        .param("type", "Sedan")
                        .param("capacity", "5")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void testGetAllRentalCars() throws Exception {
        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/rental-cars/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void testGetRentalCarById() throws Exception {
        // Replace {rentalCarId} with an existing rental car ID in your database
        long rentalCarId = 1L;

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/rental-cars/{rentalCarId}", rentalCarId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void testUpdateRentalCar() throws Exception {
        // Replace {rentalCarId} with an existing rental car ID in your database
        long rentalCarId = 1L;

        RentalCar updatedRentalCar = new RentalCar();
        updatedRentalCar.setId(rentalCarId);
        updatedRentalCar.setBrand("Updated Car");
        updatedRentalCar.setModel("Updated Type");
        updatedRentalCar.setCapacity(10);
        updatedRentalCar.setDailyRate(100.0);

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.put("/rental-cars/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedRentalCar)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void testDeleteRentalCar() throws Exception {
        // Replace {rentalCarId} with an existing rental car ID in your database
        long rentalCarId = 1L;

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.delete("/rental-cars/delete/{id}", rentalCarId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

