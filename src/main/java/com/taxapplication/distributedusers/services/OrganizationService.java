package com.taxapplication.distributedusers.services;

import com.taxapplication.distributedusers.VO.ResponseTemplateVO;
import com.taxapplication.distributedusers.VO.SalaryStructure;
import com.taxapplication.distributedusers.dto.OrganizationDto;
import com.taxapplication.distributedusers.dto.UserDto;

import java.util.List;

public interface OrganizationService {

 //   OrganizationDto createOrganization(OrganizationDto organizationDto);
    ResponseTemplateVO getServicesWithSalaryStructure(String organizationId);

    SalaryStructure getOrganizationSalaryStructure(String jwt);

    OrganizationDto getOrganizationByOrganizationId(String organizationId);
}
