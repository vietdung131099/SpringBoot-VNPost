package com.truongvietdung.model.response.blog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlogDisplayResponse {
    private int id;
    private String title;
    private String content;
    private String description;
    private String thumbnail;
    private int categoryId;
}
