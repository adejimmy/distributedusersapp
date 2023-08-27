package com.taxapplication.distributedusers.repository;

import com.taxapplication.distributedusers.domain.AssignedSubsidiaries;
import com.taxapplication.distributedusers.domain.Zones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZonesRepository extends JpaRepository<Zones, Long> {
    
}
