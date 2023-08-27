package com.taxapplication.distributedusers.services;

import com.taxapplication.distributedusers.dto.LocalGovernmentDto;

import java.util.List;

public interface LocalGovernmentService {
    List<LocalGovernmentDto> getlgas(String cityId);
    LocalGovernmentDto getlga(String addressId);
}
