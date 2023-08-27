package com.taxapplication.distributedusers.services;

import com.taxapplication.distributedusers.dto.LocalGovernmentDto;
import com.taxapplication.distributedusers.dto.StatesDto;

import java.util.List;

public interface StatesService {
    List<StatesDto> getlgas(String localgovtmentId);
    StatesDto getlga(String stateId);
}
