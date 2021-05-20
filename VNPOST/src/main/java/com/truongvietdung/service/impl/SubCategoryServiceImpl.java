package com.truongvietdung.service.impl;

import com.truongvietdung.entity.SubCategory;
import com.truongvietdung.model.response.subcategory.SubCategoryResponse;
import com.truongvietdung.repository.SubCategoryRepository;
import com.truongvietdung.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryServiceImpl implements SubCategoryService {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Override
    public List<SubCategory> findAll() {
        return subCategoryRepository.findAll();
    }

    @Override
    public List<SubCategory> findAllByCategoryId(int id) {
        return subCategoryRepository.findAllByCategoryId(id);
    }

    @Override
    public List<SubCategoryResponse> findAllCustom(int category_id) {
        return subCategoryRepository.findAllCustom(category_id);
    }

}
