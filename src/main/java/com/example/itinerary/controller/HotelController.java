package com.example.itinerary.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.itinerary.dto.ApiResponse;
import com.example.itinerary.dto.HotelFindingRequest;
import com.example.itinerary.model.Coordinates;
import com.example.itinerary.model.Hotel;
import com.example.itinerary.service.HaversineDistance;
import com.example.itinerary.service.HotelRepository;
import com.example.itinerary.service.InMemorySelectedActivitiesService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    private HotelRepository hotelRepository;
    private InMemorySelectedActivitiesService inMemorySelectedActivitiesService;

    public HotelController(HotelRepository hotelRepository, InMemorySelectedActivitiesService inMemorySelectedActivitiesService){
        this.hotelRepository=hotelRepository;
        this.inMemorySelectedActivitiesService=inMemorySelectedActivitiesService;
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<Hotel>>> getHotels(){
        List<Hotel> hotelList=hotelRepository.findAll();
        return ResponseEntity.status(200).body(new ApiResponse<>(hotelList, "Retrieved list of hotels", true));
    }

    @PostMapping("/nearby-hotels")
    public ResponseEntity<ApiResponse<List<Hotel>>> getNearbyHotels(@RequestBody HotelFindingRequest hotelFindingRequest){
        try{
            List<Coordinates> coordinateList=hotelFindingRequest.getLocationList();
            String userId=hotelFindingRequest.getUserId();
            String locationId;
            try{
                locationId=inMemorySelectedActivitiesService.getUserLocation(userId);
            }
            catch(Exception e){
                return ResponseEntity.status(400).body(new ApiResponse<>(null, "Unable to find the user to fetch relevant hotels",false)); 
            }
            List<Hotel> hotelList=hotelRepository.findByLocationId(locationId);
            List<Hotel> hotelsInRadius = new ArrayList<>();
            Set<String> seenHotelIds = new HashSet<>();

            for (Coordinates position : coordinateList) {
                double lat = position.getLat();
                double lng = position.getLng();
                for (Hotel hotel : hotelList) {
                    double distance = HaversineDistance.calculateDistance(lat, lng, hotel.getLatitude(), hotel.getLongitude());
                    if (distance <= 15 && !seenHotelIds.contains(hotel.getId())) {
                        hotelsInRadius.add(hotel);
                        seenHotelIds.add(hotel.getId());
                    }
                }
            }
            return ResponseEntity.status(200).body(new ApiResponse<>(hotelsInRadius, "Retrieved list of hotels", true));}
        catch(Exception e){
            return ResponseEntity.status(500).body(new ApiResponse<>(null, "Internal server error", false));
        }
        }
}
