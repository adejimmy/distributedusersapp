package com.taxapplication.distributedusers.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrganisationResponseModel {

    private String organization_name;
    private String organizationId;
    private String code;
    private String organization_address;
    private String organization_phone;
    private SalaryStructure salstructue;

}
