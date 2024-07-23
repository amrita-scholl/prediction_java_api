package com.practice.practiceapi.dto;

public class PredictionRequest {
    private String location;
    private int totalsqft;
    private float bath;
    private int bhk;

    // Getters and Setters

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTotalSqft() {
        return totalsqft;
    }

    public void setTotalSqft(int totalsqft) {
        this.totalsqft = totalsqft;
    }

    public float getBath() {
        return bath;
    }

    public void setBath(float bath) {
        this.bath = bath;
    }

    public int getBHK() {
        return bhk;
    }

    public void setBHK(int bhk) {
        this.bhk = bhk;
    }

}
