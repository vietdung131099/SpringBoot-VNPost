package com.truongvietdung.service.impl;

import com.truongvietdung.entity.Blog;
import com.truongvietdung.entity.SubCategory;
import com.truongvietdung.mapper.custom.BaseMapperCustom;
import com.truongvietdung.mapper.BlogMapper;
import com.truongvietdung.model.request.blog.BlogSaveRequest;
import com.truongvietdung.model.request.blog.BlogUpdateRequest;
import com.truongvietdung.model.response.blog.BlogDisplayResponse;
import com.truongvietdung.repository.BlogRepository;
import com.truongvietdung.repository.SubCategoryRepository;
import com.truongvietdung.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private SubCategoryRepository subCategoryRepository;
    @Autowired
    private BlogMapper blogMapper;


    @Override
    public void save(BlogSaveRequest blogSaveRequest) {
        SubCategory subCategory = subCategoryRepository.findOneById(blogSaveRequest.getSubcategory_id()).get();
        Blog blog = blogMapper.convertSave(blogSaveRequest);
        blog.setSubCategory(subCategory);
        blogRepository.save(blog);

        /**
         * method save thì lưu trên mem ko đẩy xuống database luôn lên nó nhanh nhưng nó ko an toàn có khả năng mất dữ liệu
         * .saveAndFlush() thì lưu luôn vào trong database an toàn hơn save nhưng nó lại chậm hơn
         * */
    }

    @Override
    public void edit(BlogUpdateRequest blogUpdateRequest) {
        SubCategory subCategory = subCategoryRepository.findOneById(blogUpdateRequest.getSubcategory_id()).get();
        Blog blog = blogMapper.convertUpdate(blogUpdateRequest);
        blog.setSubCategory(subCategory);
        blogRepository.save(blog);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids){
            blogRepository.deleteById(id);
        }
    }

    @Override
    public Optional<Blog> findOneById(int id) {
        return blogRepository.findOneById(id);

    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable.previousOrFirst());
    }

    @Override
    public List<BlogDisplayResponse> findAllByCategoryId(int id,Pageable pageable) {
        return blogRepository.findAllCustom(id,pageable);
    }

    @Override
    public List<Blog> findAllBySubCategoryId(int id, Pageable pageable) {
        return blogRepository.findAllBySubCategoryId(id,pageable);
    }

    @Override
    public List<Blog> findAllNewsByCategoryId(int id, Pageable pageable) {
        return blogRepository.findAllByCategoryId(id,pageable);
    }

    @Override
    public List<Blog> searchByTitle(String data) {
        return blogRepository.searchByTitle(data);
    }

}
