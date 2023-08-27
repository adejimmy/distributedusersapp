package com.taxapplication.distributedusers.services;

import com.taxapplication.distributedusers.dto.CountryDto;

import java.util.List;

public interface CountryService {
    CountryDto getCountry(String countryId);
}
