package com.truongvietdung.mapper;


import com.truongvietdung.entity.Blog;
import com.truongvietdung.model.request.blog.BlogSaveRequest;
import com.truongvietdung.model.request.blog.BlogUpdateRequest;
import org.mapstruct.Mapper;

@Mapper
public interface BlogMapper extends BaseMapper<Blog, BlogSaveRequest, BlogUpdateRequest> {

}
