package com.practice.practiceapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PredictionProperties {
    @JsonProperty("prediction")
    private double prediction;

    public double getPrediction() {
        return prediction;
    }

    public void setPrediction(double prediction) {
        this.prediction = prediction;
    }
}
