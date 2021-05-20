package com.truongvietdung.model.request.city;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CityUpdateRequest {
    private String id;
    private String name;
    private String nameEnglish;
    private String level;
}
