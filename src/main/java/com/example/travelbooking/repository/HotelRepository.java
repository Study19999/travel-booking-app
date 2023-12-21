package com.example.travelbooking.repository;

import com.example.travelbooking.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelRepository  extends JpaRepository<Hotel, Long> {
    List<Hotel> findByLocation(String location);
}
