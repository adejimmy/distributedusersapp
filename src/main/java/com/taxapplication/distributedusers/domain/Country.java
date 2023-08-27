package com.taxapplication.distributedusers.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="_countries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String country;
    private String country_code;
    private Boolean status=false;
    @OneToMany(mappedBy = "country_id", cascade = CascadeType.ALL)
    private List<States> states;
    private String country_id;
}
