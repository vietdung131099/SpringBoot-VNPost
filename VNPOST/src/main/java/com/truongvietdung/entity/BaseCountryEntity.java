package com.truongvietdung.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public class BaseCountryEntity {
    @Id
    private String id;
    @Column(nullable = false,columnDefinition = "NVARCHAR(100)")
    private String name;
    @Column
    private String nameEnglish;
    @Column(columnDefinition = "NVARCHAR(100)")
    private String level;
}
