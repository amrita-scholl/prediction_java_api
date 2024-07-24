package com.practice.practiceapi.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Prediction {
    @JsonProperty("id")
    private int id;

    @JsonProperty("labels")
    private List<String> labels;

    @JsonProperty("properties")
    private PredictionProperties properties;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public PredictionProperties getProperties() {
        return properties;
    }

    public void setProperties(PredictionProperties properties) {
        this.properties = properties;
    }
}
