package com.truongvietdung.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class District extends BaseCountryEntity{

//    @Column(nullable = true)
//    private long population; // dân số nó bị lỗi gì mà khi trong database có cột này lại bị lỗi ???

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id")
    private City city;

    @OneToMany(mappedBy = "district",fetch = FetchType.LAZY)
    @JsonIgnore
    List<SubDistrict> subDistricts = new ArrayList<>();
}
