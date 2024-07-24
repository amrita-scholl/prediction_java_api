package com.practice.practiceapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.practiceapi.dto.PredictionRequest;
import com.practice.practiceapi.entity.PredictionEntity;
import com.practice.practiceapi.service.PredictionService;

@RestController
@RequestMapping("/api/predict")
public class PredictionController {

    @Autowired
    private PredictionService predictionService;

    PredictionEntity entity;

    @PostMapping
    public ResponseEntity<String> getPrediction(@RequestBody PredictionRequest request) {
        request.setTotalSqft(1750);

        String prediction = predictionService.getPredictionFromModel(request);

        try {

            entity = predictionService.savePrediction(request, Double.parseDouble(prediction));

        } catch (Exception ex) {
            System.out.println("Exception !!!!" + ex);
        }
        return ResponseEntity.ok(prediction);
    }
}
