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
@Table(name="client_modules")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientModuleItems implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_clieentmoduleitems;
    @OneToOne
    @JoinColumn(name = "organizations_id")
    private Organization organizations;
    @OneToOne
    @JoinColumn(name = "module_items_id")
    private ModuleItems moduleitems;
//    @OneToOne
//    @JoinColumn(name = "charge_method_id")
//    private ChargeMethod chargemethods;
    @NotNull
    @Size(min=5, message="Service ID must be at least 5 characters long")
    private String service_id;
    @NotNull
    @Size(min=5, message="Country must be at least 5 characters long")
    private Integer country_id;
    @NotNull
    @Size(min=5, message="Address must be at least 5 characters long")
    private String client_address;
    @Digits(integer=15, fraction=0, message="Invalid Phone")
    private String client_phone;
    @Pattern(regexp="^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*"
            + "@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")
    private String client_email;
    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
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
