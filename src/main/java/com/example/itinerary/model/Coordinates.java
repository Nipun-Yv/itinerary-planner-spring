package com.example.itinerary.model;

    public class Coordinates{
        private double lat;
        private double lng;
        public Coordinates(double lat, double lng){
            this.lng=lng;
            this.lat=lat;
        }
        public double getLat(){
            return this.lat;
        }
        public double getLng(){
            return this.lng;
        }
    }