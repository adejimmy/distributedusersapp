package com.taxapplication.distributedusers.services;

import com.taxapplication.distributedusers.domain.City;
import com.taxapplication.distributedusers.dto.CityDto;

import java.util.Collection;
import java.util.List;

public interface CityService {
    List<CityDto> getCitys(String localGovtId);
    CityDto getCity(String cityId);

    public void delete(City person);

    /**
     * Delete Citys.
     */
    public void deleteAll(Collection<City> citys);

    public City save(City citys);

}
