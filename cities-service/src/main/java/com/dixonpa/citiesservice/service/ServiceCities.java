package com.dixonpa.citiesservice.service;

import com.dixonpa.citiesservice.dto.CityDTO;
import com.dixonpa.citiesservice.dto.HotelsDTO;
import com.dixonpa.citiesservice.model.Cities;
import com.dixonpa.citiesservice.repository.HotelFeignClient;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceCities implements IServiceCities {

    private final HotelFeignClient apiClient;
    List<Cities> cities = new ArrayList<>();
    @Override
    public void saveCities(Cities cities) {

    }

    @Override
    public void deleteCity(Long id) {

    }

    @Override
    @CircuitBreaker(name="hotel-service", fallbackMethod = "fallbackGetCitiesHotels")
    @Retry(name = "hotel-service ")
    public CityDTO findHotelsByCity(String name, String country) {
        Cities city = this.findCity(name, country);
        List<HotelsDTO> hotels = apiClient.findHotelByCity(city.getId_city());
       CityDTO citi = CityDTO.builder().id_city(city.getId_city())
                .name(city.getName()).continent(city.getContinent())
                .country(city.getCountry()).state(city.getState())
                .province(city.getProvince()).hotels(hotels).build();
      // createException();
       return citi;
    }

    public CityDTO fallbackGetCitiesHotels( Throwable throwable){
        return new CityDTO(9999999999L,"Fail","Fail","Fail","Fail","Fail",null);

    }

    public void createException (){
        throw new IllegalArgumentException("Test Resi4j and Circuit Breaker");
    }

    public Cities findCity(String name, String country){
        this.loadCities();
        for (Cities city:cities) {
            if ((city.getName().equals(name) && (city.getCountry().equals(country)))){
                return city;
            }
        }
        return null;
    }
    public void loadCities(){
        cities.add(new Cities(1L,"Buenos Aires", "South America", "Argentina", "Buenos Aires", "Buenos Aires"));
        cities.add(new Cities(2L,"Mexico", "North America", "Mexico", "Juanajuato", "Rosales"));
        cities.add(new Cities(3L,"Bogota", "South America", "Colombia", "Coundinamarca", "Salute"));
        cities.add(new Cities(4L,"Madrid", "Europe", "Spain", "Catalonia", "Andorra"));
        cities.add(new Cities(5L,"Barcelona", "Europe", "Spain", "Anda Lucia", "Zanelato"));
        cities.add(new Cities(6L,"Monterrey", "North America", "Mexico", "Nuevo Leon", "Chalisco"));
    }
}
