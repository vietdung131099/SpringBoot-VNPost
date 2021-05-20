package com.truongvietdung.model.response.district;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DistrictResponse {
    private String id;
    private String name;
    private String nameEnglish;
    private String level;
    private String nameCity;
}
