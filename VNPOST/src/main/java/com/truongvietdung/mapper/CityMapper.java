package com.truongvietdung.mapper;

import com.truongvietdung.entity.City;
import com.truongvietdung.model.request.city.CitySaveRequest;
import com.truongvietdung.model.request.city.CityUpdateRequest;
import org.mapstruct.Mapper;

@Mapper
public interface CityMapper extends BaseMapper<City, CitySaveRequest, CityUpdateRequest> {
}
