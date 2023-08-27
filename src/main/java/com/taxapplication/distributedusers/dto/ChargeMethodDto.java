package com.taxapplication.distributedusers.dto;

import com.taxapplication.distributedusers.domain.ChargePeriodType;
import com.taxapplication.distributedusers.domain.ClientModuleItems;
import com.taxapplication.distributedusers.domain.ClientPaymentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;
import java.sql.Timestamp;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChargeMethodDto implements Serializable {

    private Long id_chargemethod;
    private Double amount;
    private String registered_by;
    private Timestamp registered_on;
    private String chargemethod_id;
    private ChargePeriodType charge_period_type;
    private ClientPaymentType charge_payment_type;
//    private ClientModuleItemsDto clientsModulesItems;
}
