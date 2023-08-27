package com.taxapplication.distributedusers.dto;

import com.taxapplication.distributedusers.domain.Country;
import com.taxapplication.distributedusers.domain.LocalGovernment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StatesDto implements Serializable {
    private Long id;
    private String state_name;
    private String state_code;
    private LocalGovernmentDto localgovtnment;
    private CountryDto country_id;
}
