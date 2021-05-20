package com.truongvietdung.service;

import com.truongvietdung.entity.SubDistrict;
import com.truongvietdung.model.request.subDistrict.SubDistrictSaveRequest;
import com.truongvietdung.model.request.subDistrict.SubDistrictUpdateRequest;
import com.truongvietdung.model.response.subDistrict.SubDistrictResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SubDistrictService {
    List<SubDistrictResponse> findAllSubDistrictResponse(Pageable pageable);

    Optional<SubDistrict> findOneById(String id);

    void save(SubDistrictSaveRequest subDistrictSaveRequest);

    void edit(SubDistrictUpdateRequest subDistrictUpdateRequest);

    void deleteBatch(List<String> ids);

    List<SubDistrictResponse> searchSubDistricts(String name);
}
