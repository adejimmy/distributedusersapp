package com.taxapplication.distributedusers.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="organization_type")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_organization_type;
    private String organization_type_name;
    private String organization_type_id;
}
