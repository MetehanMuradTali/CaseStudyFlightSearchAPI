package com.usecase.usecase.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.usecase.usecase.models.Airport;

public interface AirportRepository extends MongoRepository<Airport, String> {
    
}
