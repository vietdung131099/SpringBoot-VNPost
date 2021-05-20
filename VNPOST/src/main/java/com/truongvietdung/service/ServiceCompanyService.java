package com.truongvietdung.service;

import com.truongvietdung.entity.ServiceCompany;

import java.util.List;
import java.util.Optional;

public interface ServiceCompanyService {
    List<ServiceCompany> findAll();

    Optional<ServiceCompany> findOneById(int id);
}
