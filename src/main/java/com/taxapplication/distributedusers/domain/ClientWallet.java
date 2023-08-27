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
public class ClientWallet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private String wallet_name;
    private Integer wallet_number;
    private String wallet_type;
    private Double balance;
    private String last_update;
    private String last_update_description;
    private String r_account_reference;
    private String r_account_name;
    private String r_currency_code;
    private String r_customer_email;
    private Integer r_account_number;
    private String r_bank_name;
    private String r_bank_code;
    private String r_collection_channel;
    private String r_reservation_reference;
    private String r_reserved_account_type;
    private String r_status;
    private Timestamp r_created_on;
    private String service_id;
    @OneToOne
    @JoinColumn(name = "organizations_id")
    private Organization organizations;
    private String created_by;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String updated_by;
    private String deleted;
    private String enabled;
}
