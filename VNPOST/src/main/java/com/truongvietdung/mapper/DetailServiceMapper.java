package com.truongvietdung.mapper;

import com.truongvietdung.entity.DetailService;
import com.truongvietdung.model.request.detailService.DetailServiceSaveRequest;
import com.truongvietdung.model.request.detailService.DetailServiceUpdateRequest;
import org.mapstruct.Mapper;

@Mapper
public interface DetailServiceMapper extends BaseMapper<DetailService, DetailServiceSaveRequest, DetailServiceUpdateRequest> {
}
