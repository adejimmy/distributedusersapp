package com.taxapplication.distributedusers.dto;

import com.taxapplication.distributedusers.domain.Organization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubsidariesDto implements Serializable {
    private Long id;
    private String subsidiary;
    private String subsidiary_code;
    private Organization organizations;
    private String admin_name;
    private String email;
    private Short mark_delete;
    private String created_by;
    private String updated_by;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String admin_phone;
    private String photo_url;
    private Integer organization_type_id;
    private Short is_holding_company;
    private String assigned_to;
    private String assigned_subsidiary_id;
}
