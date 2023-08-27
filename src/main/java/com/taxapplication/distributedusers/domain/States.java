package com.taxapplication.distributedusers.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="_states")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class States implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String state_name;
    private String state_code;
    @OneToOne(mappedBy = "state_id", cascade = CascadeType.ALL)
    private LocalGovernment localgovtnment;
    @ManyToOne
    @JoinColumn(name = "_countries_id")
    private Country country_id;
}
