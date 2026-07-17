package com.example.itinerary.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.itinerary.dto.UserSelectionDetails;


@Component
public class InMemorySelectedActivitiesService {

    HashMap<String, UserSelectionDetails>userSelectedActivities;

    public InMemorySelectedActivitiesService(){
        userSelectedActivities=new HashMap<>();
    }

    public void updateSelections(String userId,List<String> activityList,String locationId){
        userSelectedActivities.put(userId,new UserSelectionDetails(activityList,locationId));
    }

    public List<String> getUserSelections(String userId){
        if(userSelectedActivities.containsKey(userId)){
            return userSelectedActivities.get(userId).getActivities();
        }
        return new ArrayList<>();
    }
    public String getUserLocation(String userId) throws Exception{
        if(userSelectedActivities.containsKey(userId)){
            return userSelectedActivities.get(userId).getLocationId();
        }
        else{
            throw new Exception("Unable to find the user");
        }
    }
}
