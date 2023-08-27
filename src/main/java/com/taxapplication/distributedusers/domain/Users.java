package com.taxapplication.distributedusers.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="users")
@Data
@AllArgsConstructor
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer group_id;
    private String userid;
    private String fullname;
    @Column(unique = true)
    private String username;
    //The hashed password will not be EXPOSED TO THE API in the API
    @JsonIgnore
    private String password;
    @Column(unique = true)
    private String email;
    private String emailVerificationToken;
    @Column(nullable=false)
    private Boolean emailVerificationStatus = false;
    @Column(nullable = false)
    private String service_id;
    private String updated_by;
    private String updated_at;
    @Column(nullable=false)
    private Boolean inactive= false;
    private String created_by;
    private String created_at;
    private String organizationId;
    private Integer agency_id;
    private Integer tax_office_id;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns
            = @JoinColumn(name = "users_id",
            referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",
                    referencedColumnName = "id"))
    private List<Role> roles;

    public Users(Integer group_id, String userid, String fullname, String username, String password, String email, String emailVerificationToken, String service_id, String created_by, String organizationId, List<Role> roles) {
        this.group_id = group_id;
        this.userid = userid;
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.emailVerificationToken = emailVerificationToken;
        this.service_id = service_id;
        this.created_by = created_by;
        this.organizationId = organizationId;
        this.roles = roles;
    }

    public Users(Integer group_id, String userid, String fullname, String username, String password, String email, String emailVerificationToken, String service_id, String created_by, String organizationId) {
        this.group_id = group_id;
        this.userid = userid;
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.email = email;
        this.emailVerificationToken = emailVerificationToken;
        this.service_id = service_id;
        this.created_by = created_by;
        this.organizationId = organizationId;
    }

    public Users() {
    }


}

