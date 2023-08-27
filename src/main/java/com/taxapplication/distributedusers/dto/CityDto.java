package com.taxapplication.distributedusers.dto;


import com.taxapplication.distributedusers.domain.LocalGovernment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CityDto implements Serializable {
    private Long id_cities;
    private String city;
    private LocalGovernmentDto local_government_id;
    private String registered_on;
    private String city_id;
    private String service_id;
    private String session_id;
}
