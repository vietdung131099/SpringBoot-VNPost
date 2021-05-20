package com.truongvietdung.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class City extends BaseCountryEntity{

    @OneToMany(mappedBy = "city",fetch = FetchType.EAGER)
    @JsonIgnore
    List<District> districts = new ArrayList<>();
}
