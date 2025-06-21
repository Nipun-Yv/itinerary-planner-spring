package com.example.itinerary.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.itinerary.model.Activity;

public interface ActivityRepository extends JpaRepository<Activity, String>{
    
}
