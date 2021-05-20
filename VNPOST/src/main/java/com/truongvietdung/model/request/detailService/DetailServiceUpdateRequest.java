package com.truongvietdung.model.request.detailService;

import com.truongvietdung.entity.ServiceCompany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetailServiceUpdateRequest {
    private int id;
    private String title;
    private String content;
    private String thumbnail;
    private String description;
    private int service_company_id;
}
