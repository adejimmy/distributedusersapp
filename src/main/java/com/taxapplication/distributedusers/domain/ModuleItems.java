package com.taxapplication.distributedusers.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="module_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModuleItems implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String module_items_id;
    private String module_name;
    private String module_description;
    private String registered_by;
    private String registered_on;
    private String module_code;
        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(name = "moduleitems_charge_method", joinColumns
            = @JoinColumn(name = "charge_method_id",
            referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "moduleitems_id",
                    referencedColumnName = "id"))
    private List<ChargeMethod> moduleitem_charges;

    @OneToOne(mappedBy = "moduleitems", cascade = CascadeType.ALL)
    private ClientModuleItems clientModulesItems;


}
