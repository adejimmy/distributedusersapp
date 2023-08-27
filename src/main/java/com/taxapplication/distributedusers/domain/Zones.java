package com.taxapplication.distributedusers.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="_zones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Zones implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String zone;
    private String inactive;
    private Timestamp registered_on;
    private String registered_by;
    private String service_id;
    private String session_id;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="local_government_zones",
    joinColumns = @JoinColumn(name = "zone_id",
    referencedColumnName ="id"),
    inverseJoinColumns = @JoinColumn(name="local_government_id",
    referencedColumnName = "id_lga"))
    private List<LocalGovernment> localgovernmentarea;
    private String organization_id;
}
