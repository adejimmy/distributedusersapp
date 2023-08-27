package com.taxapplication.distributedusers.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignedSubsidiaries implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String subsidiary_id;
    private String assigned_subsidiary_id;
    private Timestamp created_at;
    private Timestamp updated_at;

    public AssignedSubsidiaries(String subsidiary_id, String assigned_subsidiary_id) {
        this.subsidiary_id = subsidiary_id;
        this.assigned_subsidiary_id = assigned_subsidiary_id;
    }

    public String getSubsidiary_id() {
        return subsidiary_id;
    }

    public void setSubsidiary_id(String subsidiary_id) {
        this.subsidiary_id = subsidiary_id;
    }

    public String getAssigned_subsidiary_id() {
        return assigned_subsidiary_id;
    }

    public void setAssigned_subsidiary_id(String assigned_subsidiary_id) {
        this.assigned_subsidiary_id = assigned_subsidiary_id;
    }
}
