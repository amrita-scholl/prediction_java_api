package com.practice.practiceapi.repo;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.practice.practiceapi.entity.Neo4jPrediction;

@Repository
public interface Neo4jPredictionRepository extends Neo4jRepository<Neo4jPrediction, Long> {
}
