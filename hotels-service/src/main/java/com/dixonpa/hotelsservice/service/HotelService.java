package com.dixonpa.hotelsservice.service;

import com.dixonpa.hotelsservice.model.Hotels;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService implements IHotelService{

    List<Hotels> hotelsList = new ArrayList<>();

    @Override
    public List<Hotels> getHotelsByIdCity(Long id_city) {
        List<Hotels> hotelCityList = new ArrayList<>();
        this.loadHotels();
        for (Hotels hotels:hotelsList) {
            if (hotels.getId_city() == id_city){
                hotelCityList.add(hotels);
            }
        }
        return hotelCityList;
    }

    public void loadHotels(){
        hotelsList.add(new Hotels(1L,"Paradise","5",1L));
        hotelsList.add(new Hotels(2L,"Paradise","4",2L));
        hotelsList.add(new Hotels(3L,"Paradise","3",1L));
        hotelsList.add(new Hotels(4L,"Paradise","1",2L));
        hotelsList.add(new Hotels(5L,"Paradise","2",3L));
        hotelsList.add(new Hotels(6L,"Paradise","4",1L));
    }
}

