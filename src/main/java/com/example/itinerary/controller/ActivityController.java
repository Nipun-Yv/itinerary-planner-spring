package com.example.itinerary.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.itinerary.dto.ActivityDetailsRequest;
import com.example.itinerary.dto.ActivitySelectionRequest;
import com.example.itinerary.dto.ApiResponse;
import com.example.itinerary.model.Activity;
import com.example.itinerary.service.ActivityRepository;
import com.example.itinerary.service.InMemorySelectedActivitiesService;

@RestController
public class ActivityController {

    private ActivityRepository activityRepository;
    private InMemorySelectedActivitiesService inMemorySelectedActivitiesService;

    public ActivityController(ActivityRepository activityRepository,InMemorySelectedActivitiesService inMemorySelectedActivitiesService){
        this.activityRepository=activityRepository;
        this.inMemorySelectedActivitiesService=inMemorySelectedActivitiesService;
    }
    @GetMapping("/health")
    public String getHealth(){
        return "Hello";
    }

    @GetMapping("/activities")
    public ResponseEntity<ApiResponse<List<Activity>>> getUserActivities(@RequestParam String userId){
        try {
            List<String> activityIds=inMemorySelectedActivitiesService.getUserSelections(userId);
            List<Activity> activities=activityRepository.findAllById(activityIds);
            System.out.println(activities);
            return ResponseEntity.status(200).body(new ApiResponse<>(activities, "Retrieved activities", true));

        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse<>(null, "Internal server error", false));
        }
    }
    @PostMapping("/activities")
    public ResponseEntity<ApiResponse<Void>> updateActivities(@RequestBody ActivitySelectionRequest activitySelectionRequest){
        try{
            List<String> selectedActivities=activitySelectionRequest.getSelectedActivities();
            String userId=activitySelectionRequest.getUserId();
            inMemorySelectedActivitiesService.updateSelections(userId, selectedActivities);
            return ResponseEntity.status(200).body(new ApiResponse<>(null, "Stored successfully", true));
        }
        catch(Exception e){
            return ResponseEntity.status(500).body(new ApiResponse<>(null, "Internal server error", false));
        }
    }

    @PostMapping("/activity-details")
    public ResponseEntity<ApiResponse<List<Activity>>> getActivityDetails(@RequestBody ActivityDetailsRequest activityDetailsRequest){
        try{
            List<String> selectedActivities=activityDetailsRequest.getSelectedActivities();
            System.out.println(selectedActivities);
            List<Activity> activityDetails=activityRepository.findAllById(selectedActivities);

            return ResponseEntity.status(200).body(new ApiResponse<>(activityDetails, "Stored successfully", true));
        }
        catch(Exception e){
            return ResponseEntity.status(500).body(new ApiResponse<>(null, "Internal server error", false));
        }
    }

}
