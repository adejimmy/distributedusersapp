package com.taxapplication.distributedusers.repository;

import com.taxapplication.distributedusers.domain.AssignedSubsidiaries;
import com.taxapplication.distributedusers.domain.LocalGovernment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalGovernmentInterface extends JpaRepository<LocalGovernment, Long> {
}
