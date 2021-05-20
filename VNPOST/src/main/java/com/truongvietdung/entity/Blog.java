package com.truongvietdung.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Blog extends BaseEntity{
    @Column(columnDefinition = "NTEXT",unique = true)
    private String title;
    @Column(columnDefinition = "NTEXT")
    private String content;
    @Column(columnDefinition = "NTEXT")
    private String description;
    @Column
    private String thumbnail;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subcategory_id")
    private SubCategory subCategory;


    @Override
    public String toString() {
        return "Blog{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", description='" + description + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", subCategory=" + subCategory +
                '}';
    }
}
