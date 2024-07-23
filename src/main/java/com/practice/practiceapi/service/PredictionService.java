package com.practice.practiceapi.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.client.RestTemplate;

import com.practice.practiceapi.dto.PredictionRequest;
import com.practice.practiceapi.dto.PredictionResponse;
import com.practice.practiceapi.entity.Neo4jPrediction;
import com.practice.practiceapi.entity.PredictionEntity;
import com.practice.practiceapi.repo.Neo4jPredictionRepository;
import com.practice.practiceapi.repo.PredictionRepository;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PredictionService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PredictionRepository predictionRepository;

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private Neo4jPredictionRepository neo4jPredictionRepository;

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

    @Transactional
    public void savePredictionToNeo4j(PredictionEntity entity) {
        log.info("request >> {} ", entity.getLocation());
        log.info("request >> {} ", entity.getTotalSqft());
        log.info("request >> {} ", entity.getBath());
        log.info("request >> {} ", entity.getBHK());

        log.info("response >> {} ", entity.getPredictedPrice());

        Neo4jPrediction neo4jPrediction = new Neo4jPrediction();
        neo4jPrediction.setLocation(entity.getLocation());
        neo4jPrediction.setTotalSqft(entity.getTotalSqft());
        neo4jPrediction.setBath(entity.getBath());
        neo4jPrediction.setBHK(entity.getBHK());
        neo4jPrediction.setPrediction(entity.getPredictedPrice());
        try {
            neo4jPredictionRepository.save(neo4jPrediction);

        } catch (Exception ex) {
            System.out.println("What is the Exception here !!!" + ex);
        }
    }

}
