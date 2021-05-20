package com.truongvietdung.model.request.blog;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogUpdateRequest {
    private int id;
    private String title;
    private String content;
    private String description;
    private String thumbnail;
    private int subcategory_id;
}
