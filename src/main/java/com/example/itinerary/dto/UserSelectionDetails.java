package com.example.itinerary.dto;

import java.util.List;

public class UserSelectionDetails {
    private List<String> activities;
    private String locationId;

    public UserSelectionDetails(List<String> activities, String locationId) {
        this.activities = activities;
        this.locationId = locationId;
    }
    public List<String> getActivities() { return activities; }
    public String getLocationId() { return locationId; }
}