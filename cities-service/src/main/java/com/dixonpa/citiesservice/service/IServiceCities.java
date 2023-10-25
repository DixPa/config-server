package com.dixonpa.citiesservice.service;

import com.dixonpa.citiesservice.dto.CityDTO;
import com.dixonpa.citiesservice.dto.HotelsDTO;
import com.dixonpa.citiesservice.model.Cities;

import java.util.List;

public interface IServiceCities {

    void saveCities(Cities cities);
    void deleteCity(Long id);
    CityDTO findHotelsByCity(String name, String country);
}
