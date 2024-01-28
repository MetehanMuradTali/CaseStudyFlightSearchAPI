package com.usecase.usecase.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usecase.usecase.models.Flight;
import com.usecase.usecase.service.FlightService;


import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService){
        this.flightService = flightService;
    }

    @PostMapping
    public Flight addFlight(@RequestBody Flight flight) {
        
        return flightService.createFlight(flight);

    }
    
    @GetMapping("/{id}")
    public Flight getFlight(@PathVariable String id) {
        return flightService.getFlight(id);
    }
    
    @GetMapping("/flights")
    public Map<String,List<Flight>> getFlightsbyCriteria(
            @RequestParam("departureId") String departureAirportId,
            @RequestParam("arrivalId") String arrivalAirportId,
            @RequestParam("departureDT") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime departureDateTime,
            @RequestParam(name="returnDT",required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime returnDateTime ) {
        
        Map<String, List<Flight>> result = new HashMap<>();
        if (returnDateTime != null) {
            // Çift Yön Uçuş
            List<Flight> goingWayFlights = flightService.findFlightsByCriteria(departureAirportId, arrivalAirportId, departureDateTime);
            List<Flight> returnFlights = flightService.findFlightsByCriteria(departureAirportId, arrivalAirportId, returnDateTime);
    
            result.put("goingWayFlights", goingWayFlights);
            result.put("returnFlights", returnFlights);
        } else {
            // Tek Yön Uçuş
            List<Flight> flights = flightService.findFlightsByCriteria(departureAirportId, arrivalAirportId, departureDateTime);
            result.put("flights", flights);
        }
    
        return result;
           
    }
    @DeleteMapping
    public String deleteFlight(@PathVariable String id) {
        return flightService.deleteFlight(id);
    }
}
