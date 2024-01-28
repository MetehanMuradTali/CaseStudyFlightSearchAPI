package com.usecase.usecase.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.usecase.usecase.models.Flight;

public interface FlightRepository extends MongoRepository<Flight, String>{
    
    // For Finding Flights
    @Query("{ 'departureAirportId': ?0, 'arrivalAirportId': ?1, 'departureDateTime': {$gte: ?2}, $or[{'departureAirportId': ?1, 'arrivalAirportId': ?0, 'returnDateTime': {$gte: ?2}}]}")
    List<Flight> findFlightsByCriteria(String departureAirportId, String arrivalAirportId, LocalDateTime departureDateTime);


}
