package com.truongvietdung.controller.api;

import com.truongvietdung.entity.Blog;
import com.truongvietdung.model.request.blog.BlogSaveRequest;
import com.truongvietdung.model.request.blog.BlogUpdateRequest;
import com.truongvietdung.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BlogApiController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<Void> addBlog(@Valid @RequestBody BlogSaveRequest blogSaveRequest){
        blogService.save(blogSaveRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/blog")
    public ResponseEntity<Void> deleteBlogs(@RequestBody List<Integer> ids){
        blogService.deleteBatch(ids);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/blog")
    public ResponseEntity<Void> editBlog(@RequestBody BlogUpdateRequest blogUpdateRequest){
        blogService.edit(blogUpdateRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/searchBlogs",produces = "application/json")
    public ResponseEntity<List<Blog>> searchBlogs(@RequestBody String data){
        List<Blog> blogs = blogService.searchByTitle(data);
        return ResponseEntity.ok(blogs);
    }


}
