package com.dixonpa.hotelsservice.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class Hotels {

    private Long id;
    private String name;
    private String stars;
    private Long id_city;
}
