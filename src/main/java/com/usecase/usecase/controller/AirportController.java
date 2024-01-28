package com.usecase.usecase.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usecase.usecase.models.Airport;
import com.usecase.usecase.service.AirportService;


@RestController
@RequestMapping("/api/airports")
public class AirportController {
    
    private final AirportService airportService;

    public AirportController(AirportService airportService){
        this.airportService = airportService;
    }
    @PostMapping
    public Airport addAirport(@RequestBody Airport airport) {
        return airportService.addAirport(airport);
    }
    
    @GetMapping()
    public Airport getAirport(@RequestParam("flightId") String id) {
        return airportService.getAirport(id);

    }
    
}
