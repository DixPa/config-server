package com.dixonpa.citiesservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class HotelsDTO {

    private Long id;
    private String name;
    private String stars;
    private Long id_city;
}
