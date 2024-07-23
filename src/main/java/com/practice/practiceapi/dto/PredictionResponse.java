package com.practice.practiceapi.dto;

import java.util.List;

public class PredictionResponse {
    private List<Double> prediction;

    // Getter and Setter
    public List<Double> getPrediction() {
        return prediction;
    }

    public void setPrediction(List<Double> prediction) {
        this.prediction = prediction;
    }
}
