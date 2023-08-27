package com.taxapplication.distributedusers.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subsidaries implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String subsidiary;
    private String subsidiary_code;
//    @Column(name="organization_id")
    @OneToOne
    @JoinColumn(name = "organizationId")
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


    public Subsidaries(String subsidiary, String subsidiary_code, Organization organizations, Integer organization_type_id, Short is_holding_company) {
        this.subsidiary = subsidiary;
        this.subsidiary_code = subsidiary_code;
        this.organizations = organizations;
        this.organization_type_id = organization_type_id;
        this.is_holding_company = is_holding_company;
    }

    public Subsidaries(String subsidiary, Organization organizations, Integer organization_type_id, Short is_holding_company) {
        this.subsidiary = subsidiary;
        this.organizations = organizations;
        this.organization_type_id = organization_type_id;
        this.is_holding_company = is_holding_company;
    }

    public String getSubsidiary() {
        return subsidiary;
    }

    public void setSubsidiary(String subsidiary) {
        this.subsidiary = subsidiary;
    }

    public String getSubsidiary_code() {
        return subsidiary_code;
    }

    public void setSubsidiary_code(String subsidiary_code) {
        this.subsidiary_code = subsidiary_code;
    }

    public Organization getOrganizations() {
        return organizations;
    }

    public void setOrganizations(Organization organizations) {
        this.organizations = organizations;
    }

    public Integer getOrganization_type_id() {
        return organization_type_id;
    }

    public void setOrganization_type_id(Integer organization_type_id) {
        this.organization_type_id = organization_type_id;
    }

    public Short getIs_holding_company() {
        return is_holding_company;
    }

    public void setIs_holding_company(Short is_holding_company) {
        this.is_holding_company = is_holding_company;
    }
}
