package com.truongvietdung.service.impl;

import com.truongvietdung.entity.City;
import com.truongvietdung.entity.District;
import com.truongvietdung.mapper.DistrictMapper;
import com.truongvietdung.model.request.district.DistrictSaveRequest;
import com.truongvietdung.model.request.district.DistrictUpdateRequest;
import com.truongvietdung.model.response.district.DistrictResponse;
import com.truongvietdung.repository.CityRepository;
import com.truongvietdung.repository.DistrictRepository;
import com.truongvietdung.service.DistrictService;
import com.truongvietdung.validate.DistrictValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private DistrictMapper districtMapper;

    @Override
    public List<District> findAll() {
        return districtRepository.findAll();
    }

    @Override
    public List<District> findAllByCityId(String cityId) {
        return districtRepository.findAllByCityId(cityId);
    }

    @Override
    public Page<DistrictResponse> findDetailDistrict(Pageable pageable) {
        return districtRepository.findDetailDistrict(pageable);
    }

    @Override
    public Optional<District> findOneById(String id) {
        return districtRepository.findOneById(id);
    }

    @Override
    public void save(DistrictSaveRequest districtSaveRequest) {
        DistrictSaveRequest districtSaveRequest1 = DistrictValidate.validateObjectSave(districtSaveRequest);
        District district = districtMapper.convertSave(districtSaveRequest1);
        City city = cityRepository.findOneById(districtSaveRequest1.getCityId()).get();
        district.setCity(city);
        districtRepository.save(district);
    }

    @Override
    public void edit(DistrictUpdateRequest districtUpdateRequest) {
        DistrictUpdateRequest districtUpdateRequest1 = DistrictValidate.validateObjectSave(districtUpdateRequest);
        District district = districtMapper.convertUpdate(districtUpdateRequest1);
        City city = cityRepository.findOneById(districtUpdateRequest1.getCityId()).get();
        district.setCity(city);
        districtRepository.save(district);
    }

    @Override
    public void delete(List<String> ids) {
        for(String id : ids) {
            districtRepository.deleteById(id);
        }
    }

    @Override
    public List<DistrictResponse> searchDistricts(String name) {
        return districtRepository.searchDistricts(name);
    }


}
