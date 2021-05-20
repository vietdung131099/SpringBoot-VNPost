package com.truongvietdung.entity;

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
public class ServiceCompany extends BaseEntity{
    @Column(columnDefinition = "NVARCHAR(1500)",unique = true)
    private String name;

    @OneToMany(mappedBy = "serviceCompany",fetch = FetchType.LAZY)
    List<DetailService> detailServices = new ArrayList<>();
}
