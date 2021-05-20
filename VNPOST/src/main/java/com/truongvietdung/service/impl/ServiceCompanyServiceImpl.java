package com.truongvietdung.service.impl;

import com.truongvietdung.entity.ServiceCompany;
import com.truongvietdung.repository.ServiceCompanyRepository;
import com.truongvietdung.service.ServiceCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceCompanyServiceImpl implements ServiceCompanyService {

    @Autowired
    private ServiceCompanyRepository serviceCompanyRepository;

    @Override
    public List<ServiceCompany> findAll() {
        return serviceCompanyRepository.findAll();
    }

    @Override
    public Optional<ServiceCompany> findOneById(int id) {
        return serviceCompanyRepository.findOneById(id);
    }
}
