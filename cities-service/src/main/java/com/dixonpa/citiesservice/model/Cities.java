package com.dixonpa.citiesservice.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Cities {

    private Long id_city;
    private String name;
    private String continent;
    private String country;
    private String province;
    private String state;
}
