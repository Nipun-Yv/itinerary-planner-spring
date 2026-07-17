package com.example.itinerary.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="hotels")
public class Hotel {
    @Id
    private String id;
    private  String name;
    private double latitude;
    private double longitude;
    private int star_rating;
    private float user_rating;
    private String description;
    private String room_description;
    private String amenities_list;
    private String hotel_image_urls;
    private String room_image_url;
    private int price;

    @Column(name="\"locationId\"")
    private String locationId;
    private String address;

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

    public int getStar_rating() {
        return star_rating;
    }

    public void setStar_rating(int star_rating) {
        this.star_rating = star_rating;
    }

    public float getUser_rating() {
        return user_rating;
    }

    public void setUser_rating(float user_rating) {
        this.user_rating = user_rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRoom_description() {
        return room_description;
    }

    public void setRoom_description(String room_description) {
        this.room_description = room_description;
    }

    public String getAmenities_list() {
        return amenities_list;
    }

    public void setAmenities_list(String amenities_list) {
        this.amenities_list = amenities_list;
    }

    public String getHotel_image_urls() {
        return hotel_image_urls;
    }

    public void setHotel_image_urls(String hotel_image_urls) {
        this.hotel_image_urls = hotel_image_urls;
    }

    public String getRoom_image_url() {
        return room_image_url;
    }

    public void setRoom_image_url(String room_image_url) {
        this.room_image_url = room_image_url;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
