package com.truongvietdung.model.request.detailService;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetailServiceSaveRequest {
    private String title;
    private String content;
    private String thumbnail;
    private String description;
    private int service_company_id;
}
