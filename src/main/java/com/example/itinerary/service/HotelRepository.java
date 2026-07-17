package com.example.itinerary.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.itinerary.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel,Integer>{
    public List<Hotel> findByLocationId(String locationId);
}
