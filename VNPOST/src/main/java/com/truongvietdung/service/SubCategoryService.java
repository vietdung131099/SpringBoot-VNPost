package com.truongvietdung.service;

import com.truongvietdung.entity.SubCategory;
import com.truongvietdung.model.response.subcategory.SubCategoryResponse;

import java.util.List;

public interface SubCategoryService {
    List<SubCategory> findAll();

    List<SubCategory> findAllByCategoryId(int id);

    List<SubCategoryResponse> findAllCustom(int category_id);
}
