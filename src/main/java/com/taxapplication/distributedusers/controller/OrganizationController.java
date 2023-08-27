package com.taxapplication.distributedusers.controller;

import com.taxapplication.distributedusers.VO.OrganisationResponseModel;
import com.taxapplication.distributedusers.VO.ResponseTemplateVO;
import com.taxapplication.distributedusers.VO.SalaryStructure;
import com.taxapplication.distributedusers.domain.*;
import com.taxapplication.distributedusers.dto.OrganizationDto;
import com.taxapplication.distributedusers.payload.request.OrganisationRequestModel;
import com.taxapplication.distributedusers.payload.response.MessageResponse;
import com.taxapplication.distributedusers.repository.*;
import com.taxapplication.distributedusers.security.jwt.SecurityConstants;
import com.taxapplication.distributedusers.services.OrganizationService;
import com.taxapplication.distributedusers.utilities.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/organization")
public class OrganizationController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    OrganizationRepository organisationRepository;


    @Autowired
    OrganizationService organisationServ;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    UsersRepository userRepository;

    @Autowired
    SubsidiaryRepository subsidiaryRepository;

    @Autowired
    AssignedSubsidiariesRepository assignedSubsidiariesRepository;
    @Autowired
    Utils util;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    Environment environment;
    @Autowired
    SecurityConstants jwtUtils;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody OrganisationRequestModel signUpRequest) {
        if (organisationRepository.existsByCode(signUpRequest.getOrganization_code())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Code is already taken!"));
        }

        if (organisationRepository.existsByEmail(signUpRequest.getOrganization_email())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        String publicUserId = util.generateId(30);

        String userId = util.generateId(30);
        String logourl="";
        Integer country_id =100;
        Integer state_id=10;

//        userEntity.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        encoder.encode(signUpRequest.getPassword());
        Integer group_id=100;
        String password="1234567";
        Short is_holdingcompany=1;
       String EmailVerificationToken= util.generateEmailVerificationToken(publicUserId);



                Organization organization = new Organization(
                signUpRequest.getOrganization_name(),publicUserId,
                signUpRequest.getOrganization_code(),
                signUpRequest.getOrganization_address(), signUpRequest.getOrganization_phone(),signUpRequest.getOrganization_email(),
                signUpRequest.getOrganization_contact_person(),logourl,
                signUpRequest.getCountry_id(),
                signUpRequest.getState_id(),signUpRequest.getOrganization_type(),signUpRequest.getRcc());



            Set<Role> roles = new HashSet<>();
                    Users user = new Users(group_id,userId,signUpRequest.getOrganization_contact_person(),
                    signUpRequest.getOrganization_email(),encoder.encode(password),
                    signUpRequest.getOrganization_email(),
                    EmailVerificationToken,publicUserId,signUpRequest.getOrganization_email(),publicUserId
                );

        organisationRepository.save(organization);
      //Optional<Organization> organizations=organisationRepository.findByEmail(signUpRequest.getOrganization_email());
      //  Organization organizations=organisationRepository.findByAuthorized(signUpRequest.getOrganization_email());

//        Subsidaries subsidaries = new Subsidaries(
//                publicUserId,
//                signUpRequest.getOrganization_name(),
//                organizations.getSubsidaries().getOrganizations(),
//                organizations.getOrganization_type(),
//                is_holdingcompany);

       // Set<String> strRoles = signUpRequest.getRole();
        Set<Organization> organisat = new HashSet<>();


            Organization orga = organisationRepository.findByEmail(signUpRequest.getOrganization_email())
                    .orElseThrow(() -> new RuntimeException("Error: Organisation is not found."));
             organisat.add(orga);
               Subsidaries subsidaries = new Subsidaries(signUpRequest.getOrganization_name(),
                publicUserId,
                       orga,
//                organizations.get().getSubsidaries().getOrganizations(),
                orga.getOrganization_type(),
                is_holdingcompany);

        AssignedSubsidiaries asubsidaries = new AssignedSubsidiaries(
                publicUserId,
                publicUserId);


      //  organisationRepository.save(organization);
        userRepository.save(user);
        subsidiaryRepository.save(subsidaries);
        assignedSubsidiariesRepository.save(asubsidaries);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }


    @GetMapping("/{organizationId}")
    public ResponseTemplateVO getServicesWithSalaryStructure(@PathVariable("organizationId") String organizationId) {
        //log.info("Inside getUserWithDepartment of UserController");
        return organisationServ.getServicesWithSalaryStructure(organizationId);
    }


    @GetMapping("/organizationId/{organizationId}")
    @PostAuthorize("principal == returnObject.body.organizationId")
    public ResponseEntity<OrganisationResponseModel> getOrganization(@PathVariable("organizationId") String organizationId,
                                                                     @RequestHeader("Authorization") String authorization,
                                                                     @RequestParam(value = "fields", required = false) String fields)  {

        OrganizationDto organizationDto = organisationServ.getOrganizationByOrganizationId(organizationId);

        OrganisationResponseModel returnValue = new ModelMapper().map(organizationDto, OrganisationResponseModel.class);

        // Include albums if requested
        if (fields != null) {
            String[] includeFields = fields.split(",");
            for (String field : includeFields) {
                if (field.trim().equalsIgnoreCase("salarystructure")) {
                    SalaryStructure salarystructure = organisationServ.getOrganizationSalaryStructure(authorization);
                    returnValue.setSalstructue(salarystructure);
                    break;
                }
            }
        }

        return ResponseEntity.status(HttpStatus.OK).body(returnValue);
    }

}
