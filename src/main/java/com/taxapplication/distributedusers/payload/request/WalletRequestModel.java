package com.taxapplication.distributedusers.payload.request;

import com.taxapplication.distributedusers.domain.Organization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WalletRequestModel {
    private String ref;
    private String wallet_name;
    private Integer wallet_number;
    private String wallet_type;
    private Double balance;
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
    private String service_id;
    private Organization organizations;
    private String created_by;
    private String enabled;

}
