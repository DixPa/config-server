package com.dixonpa.citiesservice.controller;

import com.dixonpa.citiesservice.dto.CityDTO;
import com.dixonpa.citiesservice.service.IServiceCities;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cities")
public class CitiesController {

    private final IServiceCities services;

    @GetMapping("/hotels")
    public CityDTO getCityAndHotels(@RequestParam String name, @RequestParam String country){
        return services.findHotelsByCity(name, country);
    }
}
