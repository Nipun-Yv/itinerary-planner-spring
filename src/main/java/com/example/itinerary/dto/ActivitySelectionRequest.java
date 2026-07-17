package com.example.itinerary.dto;

import java.util.List;

public class ActivitySelectionRequest {
    private List<String> selectedActivities;
    private String userId;
    private String locationId;

    public List<String> getSelectedActivities() {
        return selectedActivities;
    }

    public void setSelectedActivities(List<String> selectedActivities) {
        this.selectedActivities = selectedActivities;
    }
    public String getUserId(){
        return userId;
    }
    public void setUserId(String userId){
        this.userId=userId;
    }
    public String getLocationId(){
        return locationId;
    }
    public void setLocationId(String locationId){
        this.locationId=locationId;
    }
}
