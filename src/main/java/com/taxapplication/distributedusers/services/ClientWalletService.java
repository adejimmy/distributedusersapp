package com.taxapplication.distributedusers.services;

import com.taxapplication.distributedusers.domain.ClientWallet;
import com.taxapplication.distributedusers.dto.ClientWalletDto;
import com.taxapplication.distributedusers.dto.UserDto;

public interface ClientWalletService {

    ClientWalletDto createClientWallet(ClientWalletDto clientWalletDto);


}
