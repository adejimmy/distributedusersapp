package com.taxapplication.distributedusers.dto;

import com.taxapplication.distributedusers.domain.States;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDto implements Serializable {
    private Long id;
    private String country;
    private String country_code;
    private Boolean status=false;
    private List<StatesDto> states;
    private String country_id;
}
