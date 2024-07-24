package com.practice.practiceapi.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.practice.practiceapi.dto.PredictionRequest;
import com.practice.practiceapi.dto.PredictionResponse;
import com.practice.practiceapi.entity.PredictionEntity;
import com.practice.practiceapi.repo.PredictionRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PredictionService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PredictionRepository predictionRepository;

    public String getPredictionFromModel(PredictionRequest request) {

        // Form the values array
        Object[] values = new Object[] {
                request.getLocation(),
                request.getTotalSqft(),
                request.getBath(),
                request.getBHK()
        };

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("values", values);

        String url = "http://localhost:5000/predict"; // URL of your Flask API
        PredictionResponse predictionResponse = restTemplate.postForObject(url, requestBody, PredictionResponse.class);

        if (predictionResponse != null) {
            return String.valueOf(predictionResponse.getPrediction().get(0));
        } else {
            throw new RuntimeException("Failed to get prediction from model");
        }
    }

    public PredictionEntity savePrediction(PredictionRequest request, Double prediction) {
        PredictionEntity entity = new PredictionEntity();
        entity.setLocation(request.getLocation());
        entity.setTotalSqft(request.getTotalSqft());
        entity.setBath(request.getBath());
        entity.setBHK(request.getBHK());
        // Set other features as needed
        entity.setPredictedPrice(prediction);
        predictionRepository.save(entity);
        return entity;
    }
}
