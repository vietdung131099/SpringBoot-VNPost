package com.truongvietdung.service;

import com.truongvietdung.entity.DetailService;
import com.truongvietdung.model.request.detailService.DetailServiceSaveRequest;
import com.truongvietdung.model.request.detailService.DetailServiceUpdateRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface DetailService_Service {
    void save(DetailServiceSaveRequest detailServiceSaveRequest);

    void update(DetailServiceUpdateRequest detailServiceUpdateRequest);

    List<DetailService> findAll();

    List<DetailService> findAllByServiceCompanyId(int id,Pageable pageable);

    void delete(List<Integer> ids);

    Optional<DetailService> findOneById(int id);

    Page<DetailService> findAll(Pageable pageable);

}
