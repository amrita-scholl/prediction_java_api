package com.practice.practiceapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PredictionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String location;
    private int totalsqft;
    private float bath;
    private int bhk;
    // Add other features as needed
    private double predictedPrice;

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

    public Double getPredictedPrice() {
        return predictedPrice;
    }

    public void setPredictedPrice(Double predictedPrice) {
        this.predictedPrice = predictedPrice;
    }

}
