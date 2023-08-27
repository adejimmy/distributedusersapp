package com.taxapplication.distributedusers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignedSubsidiariesDto implements Serializable {
    private Long id;
    private String subsidiary_id;
    private String assigned_subsidiary_id;
    private Timestamp created_at;
    private Timestamp updated_at;
}
