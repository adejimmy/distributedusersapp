package com.taxapplication.distributedusers.repository;

import com.taxapplication.distributedusers.domain.Subsidaries;
import com.taxapplication.distributedusers.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubsidiaryRepository extends JpaRepository<Subsidaries, Long> {
}
