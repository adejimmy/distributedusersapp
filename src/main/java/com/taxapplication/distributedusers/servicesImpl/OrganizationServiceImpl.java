package com.taxapplication.distributedusers.servicesImpl;


import com.taxapplication.distributedusers.VO.ResponseTemplateVO;
import com.taxapplication.distributedusers.VO.SalaryStructure;
import com.taxapplication.distributedusers.domain.Organization;
import com.taxapplication.distributedusers.dto.OrganizationDto;
import com.taxapplication.distributedusers.exception.OrganizationServiceException;
import com.taxapplication.distributedusers.repository.OrganizationRepository;
import com.taxapplication.distributedusers.repository.UsersRepository;
import com.taxapplication.distributedusers.services.OrganizationService;
import com.taxapplication.distributedusers.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    Environment environment;
    @Autowired
    OrganizationRepository orgRepository;
    @Autowired
    private RestTemplate restTemplate;

    public ResponseTemplateVO getServicesWithSalaryStructure(String serviceId) {
     //   log.info("Inside getOrganizationWithSalary of Organization");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Organization user = orgRepository.findByOrganizationId(serviceId)
                .orElseThrow(() -> new RuntimeException("Error: Organisation is not found."));
        SalaryStructure structure =
                restTemplate.getForObject("http://localhost:8082/api/salarystructure/id/" + user.getorganizationId()
                        ,SalaryStructure.class);
        if (structure == null)
            throw new OrganizationServiceException("Error: Organisation is not found.");

        vo.setOrganisation(user);
        vo.setSalstructue(structure);

        return  vo;
    }


    @Override
    public OrganizationDto getOrganizationByOrganizationId(String organizationId) throws OrganizationServiceException {
        Organization organizationEntity = orgRepository.findByOrganizationId(organizationId)
          .orElseThrow(() -> new RuntimeException("Error: Organisation is not found."));

            return new ModelMapper().map(organizationEntity, OrganizationDto.class);
    }

    @Override
    public SalaryStructure getOrganizationSalaryStructure(String jwt) {

        String salaryStructureUrl ="http://localhost:8082/api/salarystructure/";
        //logger.info("albumsUrl = " + albumsUrl);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Bearer " + jwt);
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        ResponseEntity<SalaryStructure> salaryResponse = restTemplate.exchange(salaryStructureUrl, HttpMethod.GET,
                new HttpEntity<>(httpHeaders), new ParameterizedTypeReference<SalaryStructure>() {
                });

//        logger.info(
//                "Albums web service endpoint called and recieved " + salaryResponse.getBody().size() + " items");

        return salaryResponse.getBody();
    }



}
