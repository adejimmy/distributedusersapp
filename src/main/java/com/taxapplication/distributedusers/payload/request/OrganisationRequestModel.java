package com.taxapplication.distributedusers.payload.request;

import com.taxapplication.distributedusers.dto.ClientModuleItemsDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganisationRequestModel {
    private String organization_name;
    private String organization_code;
    private String organization_address;
    private String organization_phone;
    private String organization_email;
    private String organization_contact_person;
    private String organization_logo_url;
    private Integer country_id;
    private Integer state_id;
    private Integer organization_type;
    private String rcc;
}
