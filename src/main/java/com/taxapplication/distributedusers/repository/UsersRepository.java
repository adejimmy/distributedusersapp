package com.taxapplication.distributedusers.repository;

import com.taxapplication.distributedusers.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
//@RepositoryRestResource(exported = true)
public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String userName);

    Users findByUserid(Long userid);


    Users findByEmail(String email);

    Users findUserByEmailVerificationToken(String token);

    Users findByOrganizationId(String organisationId);
}
