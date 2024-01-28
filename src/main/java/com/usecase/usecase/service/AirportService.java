package com.usecase.usecase.service;

import org.springframework.stereotype.Service;

import com.usecase.usecase.models.Airport;
import com.usecase.usecase.repository.AirportRepository;



@Service
public class AirportService {
    
    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository){
        this.airportRepository = airportRepository;
    }

    public Airport addAirport(Airport airport){
        return airportRepository.save(airport);
    }

    public Airport getAirport(String id){
        return airportRepository.findById(id).orElseThrow(() -> new RuntimeException("Airport not Found"));
    }
}
