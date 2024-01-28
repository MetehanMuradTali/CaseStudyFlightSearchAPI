package com.usecase.usecase.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Flight{

    @Id
    private String id;
    private String departureAirportId;
    private String arrivalAirportId;
    private LocalDateTime departureDateTime;
    private LocalDateTime returnDateTime;
    private double price;


    
}
