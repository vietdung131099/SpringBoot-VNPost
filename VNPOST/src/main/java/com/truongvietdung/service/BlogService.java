package com.truongvietdung.service;

import com.truongvietdung.entity.Blog;
import com.truongvietdung.model.request.blog.BlogSaveRequest;
import com.truongvietdung.model.request.blog.BlogUpdateRequest;
import com.truongvietdung.model.response.blog.BlogDisplayResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BlogService {

    void save(BlogSaveRequest blogSaveRequest);

    void edit(BlogUpdateRequest blogUpdateRequest);

    List<Blog> findAll();

    void deleteBatch(List<Integer> ids);

    Optional<Blog> findOneById(int id);

    Page<Blog> findAll(Pageable pageable);

    List<BlogDisplayResponse> findAllByCategoryId(int id,Pageable pageable);

    List<Blog> findAllBySubCategoryId(int id,Pageable pageable);

    List<Blog> findAllNewsByCategoryId(int id,Pageable pageable);

    List<Blog> searchByTitle(String data);

}
