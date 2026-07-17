package com.example.itinerary.dto;

import java.util.List;

import com.example.itinerary.model.Coordinates;


public class HotelFindingRequest {

    private List<Coordinates> locationList;
    private String userId;

    public List<Coordinates> getLocationList(){
        return locationList;
    }
    public String getUserId(){
        return userId;
    }
}
