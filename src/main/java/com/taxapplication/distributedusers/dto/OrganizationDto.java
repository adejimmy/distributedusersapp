package com.taxapplication.distributedusers.dto;

import com.taxapplication.distributedusers.domain.ClientModuleItems;
import com.taxapplication.distributedusers.domain.ClientWallet;
import com.taxapplication.distributedusers.domain.Subsidaries;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto implements Serializable {
    private Long id;
    private String organization_name;
    private String organizationId;
    private String code;
    private String organization_address;
    private String organization_phone;
    private String email;
    private String contactPerson;
    private String logoUrl;
    private String authorized;
    private String authorized_by;
    private Timestamp authorized_on;
    private String first_use;
    private Integer country_id;
    private Integer state_id;
    private ClientModuleItems clientModuleItems;
    private ClientWallet clientWallet;
    private Subsidaries subsidaries;
    private Integer organization_type;
    private Timestamp created_at;
    private String updated_by;
    private Timestamp updated_at;
    private String rcc;
}
