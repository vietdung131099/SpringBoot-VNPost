package com.truongvietdung.repository;

import com.truongvietdung.entity.Blog;
import com.truongvietdung.model.response.blog.BlogDisplayResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;
import java.util.Optional;

public interface BlogRepository extends JpaRepository<Blog,Integer> {

    Optional<Blog> findOneById(int id);

    @Query(value = "select new com.truongvietdung.model.response.blog.BlogDisplayResponse(b.id,b.title,b.content,b.description,b.thumbnail,c.id) " +
            "from Blog b join SubCategory s on b.subCategory.id = s.id join Category c on c.id = s.category.id where c.id = ?1")
    List<BlogDisplayResponse> findAllCustom(int id, Pageable pageable);

    List<Blog> findAllBySubCategoryId(int id,Pageable pageable);

    @Query(value = "select b from Blog b join SubCategory s on b.subCategory.id = s.id join Category c on c.id = s.category.id where c.id = ?1")
    List<Blog> findAllByCategoryId(int id,Pageable pageable);

    @Query(value = "select b from Blog b where b.title like %?1%")
    List<Blog> searchByTitle(String data);

}
