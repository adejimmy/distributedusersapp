package com.taxapplication.distributedusers.payload.request;

import com.taxapplication.distributedusers.domain.Organization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubsidiayRequestModel {
    private String subsidiary;
    private String subsidiary_code;
    private Organization organizations;
    private String admin_name;
    private String email;
    private Short mark_delete;
    private String created_by;
    private String admin_phone;
    private Short is_holding_company;
    private String assigned_to;
    private String assigned_subsidiary_id;
}
