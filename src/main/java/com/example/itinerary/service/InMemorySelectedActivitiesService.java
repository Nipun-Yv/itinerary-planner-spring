package com.example.itinerary.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class InMemorySelectedActivitiesService {

    HashMap<String, List<String>>userSelectedActivities;

    public InMemorySelectedActivitiesService(){
        userSelectedActivities=new HashMap<>();
    }

    public void updateSelections(String userId,List<String> activityList){
        userSelectedActivities.put(userId,activityList);
    }

    public List<String> getUserSelections(String userId){
        if(userSelectedActivities.containsKey(userId)){
            return userSelectedActivities.get(userId);
        }
        return new ArrayList<>();
    }
}
