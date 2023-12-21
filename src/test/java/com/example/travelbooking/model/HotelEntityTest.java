package com.example.travelbooking.model;

import com.example.travelbooking.model.Hotel;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class HotelEntityTest {

    @Test
    public void testHotelEntity() {
        Hotel hotel = new Hotel();
        hotel.setId(1L);
        hotel.setName("Example Hotel");
        hotel.setLocation("City Center");
        hotel.setCapacity(100);
        hotel.setPricePerNight(150.0);

        assertEquals(1L, hotel.getId());
        assertEquals("Example Hotel", hotel.getName());
        assertEquals("City Center", hotel.getLocation());
        assertEquals(100, hotel.getCapacity());
        assertEquals(150.0, hotel.getPricePerNight(), 0.01);
    }
    @Test
    public void testAllArgsConstructor() {
        Hotel hotel = new Hotel(1L, "Example Hotel", "City Center", 100, 150.0);

        assertEquals(1L, hotel.getId());
        assertEquals("Example Hotel", hotel.getName());
        assertEquals("City Center", hotel.getLocation());
        assertEquals(100, hotel.getCapacity());
        assertEquals(150.0, hotel.getPricePerNight(), 0.01);
    }
}