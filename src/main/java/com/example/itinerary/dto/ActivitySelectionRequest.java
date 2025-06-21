package com.example.itinerary.dto;

import java.util.List;

public class ActivitySelectionRequest {
    private List<String> selectedActivities;
    private String userId;
    
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
}
