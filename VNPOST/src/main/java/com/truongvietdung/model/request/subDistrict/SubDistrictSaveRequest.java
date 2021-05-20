package com.truongvietdung.model.request.subDistrict;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubDistrictSaveRequest {
    private String id;
    private String name;
    private String nameEnglish;
    private String level;
    private String districtId;
}
