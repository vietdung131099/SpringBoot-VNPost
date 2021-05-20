package com.truongvietdung.model.request.blog;

import com.truongvietdung.validate.annotation.BlogConstraint;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogSaveRequest {

    @BlogConstraint
    private String title;
    private String content;
    private String description;
    private String thumbnail;
    private int subcategory_id;
}
