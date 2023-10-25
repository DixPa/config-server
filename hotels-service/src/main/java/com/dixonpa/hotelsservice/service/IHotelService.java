package com.dixonpa.hotelsservice.service;

import com.dixonpa.hotelsservice.model.Hotels;

import java.util.List;

public interface IHotelService {

    List<Hotels> getHotelsByIdCity(Long id_city);
}
