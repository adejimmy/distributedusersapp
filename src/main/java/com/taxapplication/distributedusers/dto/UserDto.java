package com.taxapplication.distributedusers.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taxapplication.distributedusers.domain.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {
    private Long id;
    private Integer group_id;
    private String fullname;
    private String userid;
    private String username;
    //The hashed password will not be EXPOSED TO THE API in the API
    private String password;
    private String emailVerificationToken;
    private Boolean emailVerificationStatus = false;
    private String email;
    private String service_id;
    private String updated_by;
    private String updated_at;
    private Boolean inactive= false;
    private String created_by;
    private String created_at;
    private String organizationId;
    private Integer agency_id;
    private Integer tax_office_id;
    private List<RoleDto> roles;
}
