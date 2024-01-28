package com.usecase.usecase.models;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Airport {

    @Id
    private String id;
    private String city;

}
