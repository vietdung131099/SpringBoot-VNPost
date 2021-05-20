package com.truongvietdung.model.response.subDistrict;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubDistrictResponse {
    private String id;
    private String name;
    private String nameEnglish;
    private String level;
    private String nameDistrict;
    private String nameCity;
}