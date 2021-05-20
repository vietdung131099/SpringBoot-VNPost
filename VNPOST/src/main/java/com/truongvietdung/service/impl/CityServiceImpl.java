package com.truongvietdung.service.impl;

import com.truongvietdung.entity.City;
import com.truongvietdung.mapper.CityMapper;
import com.truongvietdung.model.request.city.CitySaveRequest;
import com.truongvietdung.model.request.city.CityUpdateRequest;
import com.truongvietdung.repository.CityRepository;
import com.truongvietdung.service.CityService;
import com.truongvietdung.validate.CityValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CityMapper cityMapper;

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public Page<City> findAll(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }

    @Override
    public void save(CitySaveRequest citySaveRequest) {
        CitySaveRequest citySaveRequest1 = CityValidate.validateObjectSave(citySaveRequest);
        City city = cityMapper.convertSave(citySaveRequest1);
        cityRepository.save(city);
    }

    @Override
    public void edit(CityUpdateRequest cityUpdateRequest) {
        CityUpdateRequest cityUpdateRequest1 = CityValidate.validateObjectSave(cityUpdateRequest);
        City city = cityMapper.convertUpdate(cityUpdateRequest1);
        cityRepository.save(city);
    }

    @Override
    public void deleteBatch(List<String> ids) {
        for(String id : ids){
            cityRepository.deleteById(id);
        }
    }

    @Override
    public Optional<City> findOneById(String id) {
        return cityRepository.findOneById(id);
    }

    @Override
    public List<City> searchCities(String name) {
        return cityRepository.searchCities(name);
    }
}
