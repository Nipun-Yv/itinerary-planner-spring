package com.example.itinerary.dto;

import java.util.List;

public class ActivityDetailsRequest {
    private List<String> selectedActivities;
    
    public List<String> getSelectedActivities() {
        return selectedActivities;
    }

    public void setSelectedActivities(List<String> selectedActivities) {
        this.selectedActivities = selectedActivities;
    }
}
