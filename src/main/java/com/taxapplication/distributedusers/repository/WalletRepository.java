package com.taxapplication.distributedusers.repository;

import com.taxapplication.distributedusers.domain.ClientWallet;
import com.taxapplication.distributedusers.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<ClientWallet, Long> {
}
