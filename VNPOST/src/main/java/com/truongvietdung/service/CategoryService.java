package com.truongvietdung.service;

import com.truongvietdung.entity.Category;
import com.truongvietdung.model.response.category.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    List<CategoryResponse> findAllCustom();
}
