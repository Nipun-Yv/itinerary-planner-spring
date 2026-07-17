package com.example.itinerary.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="activities")
public class Activity {
    @Id
    private String id;
    private String name;
    private String description;
    private int duration;
    private int price;
    private String category;

    @Column(name = "\"isActive\"")
    private boolean isActive;

    @Column(name = "\"attractionId\"")
    private String attractionId;
    
    private double latitude;
    private double longitude;
    private double rating;
    @Column(name = "user_rating_count")
    private int user_rating_count;

    public int getUserRatingCount(){
        return user_rating_count;
    }
    public void setUserRatingCount(int count){
        this.user_rating_count=count;
    }
    public double getRating(){
        return rating;
    }

    public void setRating(double rating){
        this.rating=rating;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getAttractionId() {
        return attractionId;
    }

    public void setAttractionId(String attractionId) {
        this.attractionId = attractionId;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
