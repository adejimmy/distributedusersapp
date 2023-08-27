package com.taxapplication.distributedusers.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="charge_method")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChargeMethod implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private Double amount;
    private String registered_by;
    private Timestamp registered_on;
    @Column(nullable = false)
    private String chargemethod_id;
    @Column(nullable = false)
    private ChargePeriodType charge_period_type;
    @Column(nullable = false)
    private ClientPaymentType charge_payment_type;

//    @OneToOne(mappedBy = "chargemethods", cascade = CascadeType.ALL)
//    private ClientModuleItems clientsModulesItems;

}
