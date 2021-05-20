package com.truongvietdung.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseEntity{
    @Column(columnDefinition = "NVARCHAR(1000)",unique = true)
    private String name;
    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    @JsonIgnore
    List<SubCategory> subCategories = new ArrayList<>();
}
