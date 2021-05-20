package com.truongvietdung.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class DetailService extends BaseEntity{
    @Column(columnDefinition = "NTEXT",unique = true)
    private String title;
    @Column(columnDefinition = "NTEXT")
    private String content;
    @Column(columnDefinition = "NTEXT")
    private String description;
    @Column
    private String thumbnail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_company_id")
    private ServiceCompany serviceCompany;
}
