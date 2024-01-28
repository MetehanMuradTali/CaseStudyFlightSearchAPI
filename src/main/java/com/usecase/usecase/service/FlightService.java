package com.usecase.usecase.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.usecase.usecase.models.Flight;
import com.usecase.usecase.repository.FlightRepository;


@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository){
        this.flightRepository = flightRepository;
    }
    public Flight createFlight(Flight flight){
        return flightRepository.save(flight);
    }
    public Flight getFlight(String id){
        return flightRepository.findById(id).orElseThrow(() -> new RuntimeException("Flight not Found"));
    }

    public List<Flight> findFlightsByCriteria(String departureAirportId, String arrivalAirportId, LocalDateTime departureDateTime){
        return flightRepository.findFlightsByCriteria(departureAirportId, arrivalAirportId, departureDateTime);
    }

    public String deleteFlight(String id){
        flightRepository.deleteById(id);
        return ("Deleted");
    } 
    

    
}
