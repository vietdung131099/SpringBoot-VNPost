package com.truongvietdung.service;

import com.truongvietdung.entity.City;
import com.truongvietdung.model.request.city.CitySaveRequest;
import com.truongvietdung.model.request.city.CityUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CityService {
    List<City> findAll();

    Page<City> findAll(Pageable pageable);

    void save(CitySaveRequest citySaveRequest);

    void edit(CityUpdateRequest cityUpdateRequest);

    void deleteBatch(List<String> ids);

    Optional<City> findOneById(String id);

    List<City> searchCities(String name);
}
