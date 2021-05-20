package com.truongvietdung.service.impl;

import com.truongvietdung.entity.DetailService;
import com.truongvietdung.entity.ServiceCompany;
import com.truongvietdung.mapper.DetailServiceMapper;
import com.truongvietdung.mapper.custom.BaseMapperCustom;
import com.truongvietdung.model.request.detailService.DetailServiceSaveRequest;
import com.truongvietdung.model.request.detailService.DetailServiceUpdateRequest;
import com.truongvietdung.repository.DetailServiceRepository;
import com.truongvietdung.repository.ServiceCompanyRepository;
import com.truongvietdung.service.DetailService_Service;
import com.truongvietdung.validate.DetailServiceValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetailServiceImpl implements DetailService_Service {

    @Autowired
    private DetailServiceRepository detailServiceRepository;
    @Autowired
    private ServiceCompanyRepository serviceCompanyRepository;
    @Autowired
    private DetailServiceMapper detailServiceMapper;

    @Override
    public void save(DetailServiceSaveRequest detailServiceSaveRequest) {
        DetailServiceSaveRequest detailServiceSaveRequest1 = DetailServiceValidate.validateObjectSave(detailServiceSaveRequest);
        ServiceCompany serviceCompany = serviceCompanyRepository.findOneById(detailServiceSaveRequest1.getService_company_id()).get();
        DetailService detailService = detailServiceMapper.convertSave(detailServiceSaveRequest1);
        detailService.setServiceCompany(serviceCompany);
        detailServiceRepository.save(detailService);
    }

    @Override
    public void update(DetailServiceUpdateRequest detailServiceUpdateRequest) {
        DetailServiceUpdateRequest detailServiceUpdateRequest1 = DetailServiceValidate.validateObjectSave(detailServiceUpdateRequest);
        ServiceCompany serviceCompany = serviceCompanyRepository.findOneById(detailServiceUpdateRequest1.getService_company_id()).get();
        DetailService detailService = detailServiceMapper.convertUpdate(detailServiceUpdateRequest1);
        detailService.setServiceCompany(serviceCompany);
        detailServiceRepository.save(detailService);
    }

    @Override
    public List<DetailService> findAll() {
        return detailServiceRepository.findAll();
    }

    @Override
    public List<DetailService> findAllByServiceCompanyId(int id,Pageable pageable) {
        return detailServiceRepository.findAllByServiceCompanyId(id,pageable);
    }

    @Override
    public void delete(List<Integer> ids) {
        for(Integer id : ids){
            detailServiceRepository.deleteById(id);
        }
    }

    @Override
    public Optional<DetailService> findOneById(int id) {
        return detailServiceRepository.findOneById(id);
    }

    @Override
    public Page<DetailService> findAll(Pageable pageable) {
        return detailServiceRepository.findAll(pageable);
    }

}
