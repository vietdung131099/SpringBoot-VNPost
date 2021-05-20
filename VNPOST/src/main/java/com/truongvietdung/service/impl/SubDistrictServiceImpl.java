package com.truongvietdung.service.impl;

import com.truongvietdung.entity.District;
import com.truongvietdung.entity.SubDistrict;
import com.truongvietdung.mapper.SubDistrictMapper;
import com.truongvietdung.model.request.subDistrict.SubDistrictSaveRequest;
import com.truongvietdung.model.request.subDistrict.SubDistrictUpdateRequest;
import com.truongvietdung.model.response.subDistrict.SubDistrictResponse;
import com.truongvietdung.repository.DistrictRepository;
import com.truongvietdung.repository.SubDistrictRepository;
import com.truongvietdung.service.SubDistrictService;
import com.truongvietdung.validate.SubDistrictValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubDistrictServiceImpl implements SubDistrictService {

    @Autowired
    private SubDistrictRepository subDistrictRepository;
    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private SubDistrictMapper subDistrictMapper;


    @Override
    public List<SubDistrictResponse> findAllSubDistrictResponse(Pageable pageable) {
        return subDistrictRepository.findAllDetailSubDistrict(pageable);
    }

    @Override
    public Optional<SubDistrict> findOneById(String id) {
        return subDistrictRepository.findOneById(id);
    }

    @Override
    public void save(SubDistrictSaveRequest subDistrictSaveRequest) {
        SubDistrictSaveRequest subDistrictSaveRequest1 = SubDistrictValidate.validateObjectSave(subDistrictSaveRequest);
        SubDistrict subDistrict = subDistrictMapper.convertSave(subDistrictSaveRequest1);
        District district = districtRepository.findOneById(subDistrictSaveRequest1.getDistrictId()).get();
        subDistrict.setDistrict(district);
        subDistrictRepository.save(subDistrict);
    }

    @Override
    public void edit(SubDistrictUpdateRequest subDistrictUpdateRequest) {
        SubDistrictUpdateRequest subDistrictUpdateRequest1 = SubDistrictValidate.validateObjectSave(subDistrictUpdateRequest);
        SubDistrict subDistrict = subDistrictMapper.convertUpdate(subDistrictUpdateRequest1);
        District district = districtRepository.findOneById(subDistrictUpdateRequest1.getDistrictId()).get();
        subDistrict.setDistrict(district);
        subDistrictRepository.save(subDistrict);
    }

    @Override
    public void deleteBatch(List<String> ids) {
        for(String id : ids) {
            subDistrictRepository.deleteById(id);
        }
    }

    @Override
    public List<SubDistrictResponse> searchSubDistricts(String name) {
        return subDistrictRepository.searchSubDistricts(name);
    }
}
