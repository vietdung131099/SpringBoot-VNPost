package com.truongvietdung.mapper;

import com.truongvietdung.entity.District;
import com.truongvietdung.model.request.district.DistrictSaveRequest;
import com.truongvietdung.model.request.district.DistrictUpdateRequest;
import org.mapstruct.Mapper;

@Mapper
public interface DistrictMapper extends BaseMapper<District, DistrictSaveRequest, DistrictUpdateRequest> {
}
