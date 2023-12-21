package com.example.travelbooking.service;

import com.example.travelbooking.model.Hotel;
import com.example.travelbooking.repository.HotelRepository;
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
public class HotelServiceTest {

    @Autowired
    private HotelService hotelService;

    @Autowired
    private HotelRepository hotelRepository;

    @Test
    public void testGetAllHotels() {
        // Arrange
        Hotel hotel1 = new Hotel(1L, "Example Hotel 1", "City Center", 100, 150.0);
        Hotel hotel2 = new Hotel(2L, "Example Hotel 2", "Suburb", 80, 120.0);

        // Save hotels directly using the real repository
        hotelRepository.saveAll(List.of(hotel1, hotel2));

        // Act
        List<Hotel> result = hotelService.getAllHotels();

        // Assert
        assertEquals(2, result.size());
    }
    @Test
    public void testSearchHotels() {
        // Arrange
        Hotel hotel1 = new Hotel(1L, "Example Hotel 1", "City Center", 100, 150.0);
        Hotel hotel2 = new Hotel(2L, "Example Hotel 2", "Suburb", 80, 120.0);

        // Save hotels directly using the real repository
        hotelRepository.saveAll(List.of(hotel1, hotel2));

        // Act
        List<Hotel> result = hotelService.searchHotels("City Center");

        // Assert
        assertEquals(1, result.size());
        assertEquals("Example Hotel 1", result.get(0).getName());
    }
    @Test
    public void testGetHotelById() {
        // Arrange
        Hotel hotel = new Hotel(1L, "Example Hotel", "City Center", 100, 150.0);

        // Save hotel directly using the real repository
        hotelRepository.save(hotel);

        // Act
        Optional<Hotel> result = hotelService.getHotelById(1L);

        // Assert
        assertEquals("Example Hotel", result.get().getName());
    }
    @Test
    public void testSaveHotel() {
        // Arrange
        Hotel hotelToSave = new Hotel(null, "Example Hotel", "City Center", 100, 150.0);

        // Act
        Hotel savedHotel = hotelService.saveHotel(hotelToSave);

        // Assert
        assertEquals("Example Hotel", savedHotel.getName());
    }
    @Test
    public void testDeleteHotel() {
        // Arrange
        Hotel hotelToDelete = new Hotel(null, "Example Hotel", "City Center", 100, 150.0);

        // Save hotel directly using the real repository
        Hotel savedHotel = hotelRepository.save(hotelToDelete);

        // Act
        hotelService.deleteHotel(savedHotel.getId());

        // Assert
        assertFalse(hotelRepository.existsById(savedHotel.getId()));
    }
}