package com.dixonpa.citiesservice.dto;

import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class CityDTO {

    private Long id_city;
    private String name;
    private String continent;
    private String country;
    private String province;
    private String state;
    private List<HotelsDTO> hotels;
}
