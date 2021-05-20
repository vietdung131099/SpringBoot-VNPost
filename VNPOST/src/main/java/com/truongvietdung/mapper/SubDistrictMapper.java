package com.truongvietdung.mapper;

import com.truongvietdung.entity.SubDistrict;
import com.truongvietdung.model.request.subDistrict.SubDistrictSaveRequest;
import com.truongvietdung.model.request.subDistrict.SubDistrictUpdateRequest;
import org.mapstruct.Mapper;

@Mapper
public interface SubDistrictMapper extends BaseMapper<SubDistrict, SubDistrictSaveRequest, SubDistrictUpdateRequest> {
}
