package com.practice.practiceapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.practiceapi.entity.PredictionEntity;

@Repository
public interface PredictionRepository extends JpaRepository<PredictionEntity, Long> {

}
