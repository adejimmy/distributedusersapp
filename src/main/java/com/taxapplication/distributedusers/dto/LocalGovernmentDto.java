package com.taxapplication.distributedusers.dto;

import com.taxapplication.distributedusers.domain.City;
import com.taxapplication.distributedusers.domain.States;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalGovernmentDto implements Serializable {

    private Long id_lga;

    private String lga_id;

    private String lga;
    private StatesDto state_id;
    private CityDto cities;
    private String created_by;
    private Timestamp created_at;
    private String updated_by;
    private Timestamp updated_at;
    private String lga_code;
}
