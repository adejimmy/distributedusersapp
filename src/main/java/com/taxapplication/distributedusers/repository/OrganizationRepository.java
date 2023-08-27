package com.taxapplication.distributedusers.repository;

import com.taxapplication.distributedusers.domain.AssignedSubsidiaries;
import com.taxapplication.distributedusers.domain.Organization;
import com.taxapplication.distributedusers.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization, Long> {

   Optional<Organization> findByEmail(String username);


   // Organization findByEmail(String email);
     //Organization findByAuthorized(String username);

    Boolean existsByCode(String username);

    Boolean existsByEmail(String email);

    Optional<Organization> findByOrganizationId(String organisationId);

;
}
