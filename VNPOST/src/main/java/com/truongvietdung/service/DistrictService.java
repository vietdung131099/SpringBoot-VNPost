package com.truongvietdung.service;

import com.truongvietdung.entity.District;
import com.truongvietdung.model.request.district.DistrictSaveRequest;
import com.truongvietdung.model.request.district.DistrictUpdateRequest;
import com.truongvietdung.model.response.district.DistrictResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface DistrictService {

    List<District> findAll();

    List<District> findAllByCityId(String cityId);

    Page<DistrictResponse> findDetailDistrict(Pageable pageable);

    Optional<District> findOneById(String id);

    void save(DistrictSaveRequest districtSaveRequest);

    void edit(DistrictUpdateRequest districtUpdateRequest);

    void delete(List<String> ids);

    List<DistrictResponse> searchDistricts(String name);
}
