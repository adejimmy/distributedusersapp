package com.taxapplication.distributedusers.VO;


import com.taxapplication.distributedusers.domain.Organization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {

        private Organization organisation;
        private SalaryStructure salstructue;

}
