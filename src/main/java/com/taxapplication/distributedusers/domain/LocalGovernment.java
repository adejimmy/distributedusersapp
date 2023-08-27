package com.taxapplication.distributedusers.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name="_local_government_area")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalGovernment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_lga;
    @Column(nullable = false)
    private String lga_id;
    @Column(nullable = false)
    private String lga;
    @OneToOne
    @JoinColumn(name = "_states_id")
    private States state_id;
    @OneToOne(mappedBy = "local_government_id", cascade = CascadeType.ALL)
    private City cities;
    private String created_by;
    private Timestamp created_at;
    private String updated_by;
    private Timestamp updated_at;
    private String lga_code;
}
