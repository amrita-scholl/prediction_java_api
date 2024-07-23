package com.practice.practiceapi.entity;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Node("prediction-api")
public class Neo4jPrediction {

    @Id
    private Long id;

    @Property(name = "location")
    private String location;

    @Property(name = "totalsqft")
    private int totalsqft;

    @Property(name = "bath")
    private float bath;

    @Property(name = "bhk")
    private int bhk;

    @Property(name = "prediction")
    private Double prediction;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Double getPrediction() {
        return prediction;
    }

    public void setPrediction(Double prediction) {
        this.prediction = prediction;
    }
}
