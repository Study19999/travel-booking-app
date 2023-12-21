package com.example.travelbooking.controller;

import com.example.travelbooking.model.Hotel;
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
public class HotelControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testAddHotel() throws Exception {
        // Arrange
        String hotelJson = "{\"name\":\"Example Hotel\",\"location\":\"City Center\",\"capacity\":100,\"pricePerNight\":150.0}";

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/hotels/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(hotelJson))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void testSearchHotels() throws Exception {
        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/hotels/search")
                        .param("location", "City Center")
                        .param("capacity", "100")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void testGetAllHotels() throws Exception {
        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/hotels/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void testGetHotelById() throws Exception {
        // Replace {hotelId} with an existing hotel ID in your database
        long hotelId = 1L;

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/hotels/{hotelId}", hotelId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void testUpdateHotel() throws Exception {
        // Replace {hotelId} with an existing hotel ID in your database
        long hotelId = 1L;

        Hotel updatedHotel = new Hotel();
        updatedHotel.setId(hotelId);
        updatedHotel.setName("Updated Hotel");
        updatedHotel.setLocation("Updated Location");
        updatedHotel.setCapacity(200);
        updatedHotel.setPricePerNight(200.0);

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.put("/hotels/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedHotel)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    @Test
    public void testDeleteHotel() throws Exception {
        // Replace {hotelId} with an existing hotel ID in your database
        long hotelId = 1L;

        // Act and Assert
        mockMvc.perform(MockMvcRequestBuilders.delete("/hotels/delete/{id}", hotelId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
