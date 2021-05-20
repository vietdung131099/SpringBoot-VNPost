package com.truongvietdung.service.impl;

import com.truongvietdung.entity.Category;
import com.truongvietdung.model.response.category.CategoryResponse;
import com.truongvietdung.repository.CategoryRepository;
import com.truongvietdung.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<CategoryResponse> findAllCustom() {
        return categoryRepository.findAllCustom();
    }
}
