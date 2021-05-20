package com.truongvietdung.model.response.subcategory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubCategoryResponse {
    private int categoryId;
    private int subCategoryId;
    private String name;
}
