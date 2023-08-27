package com.taxapplication.distributedusers.dto;

import com.taxapplication.distributedusers.domain.ChargeMethod;
import com.taxapplication.distributedusers.domain.ClientPaymentType;
import com.taxapplication.distributedusers.domain.ModuleItems;
import com.taxapplication.distributedusers.domain.Organization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientModuleItemsDto implements Serializable {
    private Long id_clieentmoduleitems;
    private OrganizationDto organizations;
    private ModuleItemsDto moduleitems;
//    private ChargeMethodDto chargemethods;
    private String service_id;
    private Integer country_id;
    private String client_address;
    private String client_phone;
    private String client_email;
    private String client_contact_person;
    private String client_admin;
    private String client_admin_email;
    private String client_supervisor;
    private String service_logo_url;
    private String last_modified_by;
    private Timestamp last_modified_on;
    private Integer service_status=0;
    private String last_disabled_by;
    private Timestamp last_disabled_on;
    private String last_reactivated_by;
    private Timestamp last_reactivated_on;
    private String reason_for_last_disable;
    private String reason_for_last_reactivate;
    private String registered_by;
    private Timestamp registered_on;
    private String state_id;
    private Double amount;
}
