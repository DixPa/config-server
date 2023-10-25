package com.dixonpa.hotelsservice.controller;

import com.dixonpa.hotelsservice.model.Hotels;
import com.dixonpa.hotelsservice.service.IHotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
@RequiredArgsConstructor
public class HotelController {

    private final IHotelService service;

    @GetMapping("/{id_city}")
    public List<Hotels> getHotelsByCityId (@PathVariable Long id_city){
        return service.getHotelsByIdCity(id_city);
    }

}
