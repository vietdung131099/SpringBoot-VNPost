package com.truongvietdung.repository;

import com.truongvietdung.entity.SubCategory;
import com.truongvietdung.model.response.subcategory.SubCategoryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SubCategoryRepository extends JpaRepository<SubCategory,Integer> {
    Optional<SubCategory> findOneById(int id);

    @Query(value = "select new com.truongvietdung.model.response.subcategory.SubCategoryResponse(s.category.id,s.id,s.name) from SubCategory s group by s.category.id,s.id,s.name having s.category.id=?1 ")
    List<SubCategoryResponse> findAllCustom(int category_id);

    List<SubCategory> findAllByCategoryId(int id);
}
