package com.dixonpa.citiesservice.repository;

import com.dixonpa.citiesservice.dto.HotelsDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "hotel-service")
public interface HotelFeignClient {

    @GetMapping("/api/hotels/{id_city}")
    List<HotelsDTO> findHotelByCity (@PathVariable Long id_city);
}
