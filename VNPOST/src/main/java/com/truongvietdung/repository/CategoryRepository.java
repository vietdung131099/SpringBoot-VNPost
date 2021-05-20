package com.truongvietdung.repository;

import com.truongvietdung.entity.Category;
import com.truongvietdung.model.response.category.CategoryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    @Query(value = "select new com.truongvietdung.model.response.category.CategoryResponse(c.id,c.name) from Category c")
    List<CategoryResponse> findAllCustom();
}
