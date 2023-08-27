package com.taxapplication.distributedusers.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="_cities")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_cities;
    @Column(nullable = false)
    private String city;
    @OneToOne
    @JoinColumn(name = "_local_government_area_id_lga")
    private LocalGovernment local_government_id;
    private String registered_on;
    @Column(nullable = false)
    private String city_id;
    private String service_id;
    private String session_id;
}
