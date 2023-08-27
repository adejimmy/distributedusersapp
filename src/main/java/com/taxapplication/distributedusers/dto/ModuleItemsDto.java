package com.taxapplication.distributedusers.dto;

import com.taxapplication.distributedusers.domain.ChargeMethod;
import com.taxapplication.distributedusers.domain.ClientModuleItems;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModuleItemsDto implements Serializable {

    private Long id;
    private String module_items_id;
    private String module_name;
    private String module_description;
    private String registered_by;
    private String registered_on;
    private String module_code;
    private List<ChargeMethodDto> moduleitem_charges;
    private ClientModuleItemsDto clientModulesItems;
}
