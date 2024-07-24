package com.practice.practiceapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PredictionResponse {
    @JsonProperty("message")
    private String message;

    @JsonProperty("prediction")
    private Prediction prediction;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Prediction getPrediction() {
        return prediction;
    }

    public void setPrediction(Prediction prediction) {
        this.prediction = prediction;
    }
}
