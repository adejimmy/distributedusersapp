package com.taxapplication.distributedusers.domain;

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
import java.util.List;

@Entity
@Table(name="organizations")
@Data
public class Organization implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String organization_name;
    private String organizationId;
    @Column(name="organization_code")
    private String code;
    private String organization_address;
    private String organization_phone;
    @Pattern(regexp="^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*"
            + "@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")
    private String email;
    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    @Column(name="organization_contact_person")
    private String contactPerson;
    @Column(name="logoUrl")
    private String logoUrl;
    private String authorized;
    private String authorized_by;
    private Timestamp authorized_on;
    private String first_use;
    @NotNull
   // @Size(min=1, message="Please Select Country")
    private Integer country_id;
    @NotNull
//    @Size(min=1, message="Please Select State")
    private Integer state_id;
    @OneToOne(mappedBy = "organizations", cascade = CascadeType.ALL)
    private ClientModuleItems clientModuleItems;
    @OneToOne(mappedBy = "organizations", cascade = CascadeType.ALL)
    private ClientWallet clientWallet;
    @OneToOne(mappedBy = "organizations", cascade = CascadeType.ALL)
    private Subsidaries subsidaries;
    private Integer organization_type;
    private Timestamp created_at;
    private String updated_by;
    private Timestamp updated_at;
    private String rcc;


    public Organization() {
    }

    public Organization(String organization_name, String organizationId, String organization_code, String organization_address, String organization_phone, String organization_email, String organization_contact_person, String logoUrl, Integer country_id, Integer state_id, Integer organization_type, String rcc) {
        this.organization_name = organization_name;
        this.organizationId = organizationId;
        this.code = organization_code;
        this.organization_address = organization_address;
        this.organization_phone = organization_phone;
        this.email = organization_email;
        this.contactPerson = organization_contact_person;
        this.logoUrl = logoUrl;
        this.country_id = country_id;
        this.state_id = state_id;
        this.organization_type = organization_type;
        this.rcc = rcc;
    }

    public String getOrganization_name() {
        return organization_name;
    }

    public void setOrganization_name(String organization_name) {
        this.organization_name = organization_name;
    }

    public String getorganizationId() {
        return organizationId;
    }

    public void setorganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganization_code() {
        return code;
    }

    public void setOrganization_code(String organization_code) {
        this.code = organization_code;
    }

    public String getOrganization_address() {
        return organization_address;
    }

    public void setOrganization_address(String organization_address) {
        this.organization_address = organization_address;
    }

    public String getOrganization_phone() {
        return organization_phone;
    }

    public void setOrganization_phone(String organization_phone) {
        this.organization_phone = organization_phone;
    }

    public String getEmail() {
        return email;
    }

    public void setOrganization_email(String organization_email) {
        this.email = organization_email;
    }

    public String getOrganization_contact_person() {
        return contactPerson;
    }

    public void setOrganization_contact_person(String organization_contact_person) {
        this.contactPerson = organization_contact_person;
    }

    public String getlogoUrl() {
        return logoUrl;
    }

    public void setlogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Integer getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Integer country_id) {
        this.country_id = country_id;
    }

    public Integer getState_id() {
        return state_id;
    }

    public void setState_id(Integer state_id) {
        this.state_id = state_id;
    }

    public Integer getOrganization_type() {
        return organization_type;
    }

    public void setOrganization_type(Integer organization_type) {
        this.organization_type = organization_type;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public String getRcc() {
        return rcc;
    }

    public void setRcc(String rcc) {
        this.rcc = rcc;
    }
}
