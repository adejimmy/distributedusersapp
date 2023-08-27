package com.taxapplication.distributedusers.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssignedSubsidiariesRequestModel {
    private Integer subsidiary_id;
    private Integer assigned_subsidiary_id;
}
