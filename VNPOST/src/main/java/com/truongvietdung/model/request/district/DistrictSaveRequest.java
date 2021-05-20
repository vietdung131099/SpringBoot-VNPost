package com.truongvietdung.model.request.district;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DistrictSaveRequest {
    private String id;
    private String name;
    private String nameEnglish;
    private String level;
    private String cityId;
}
