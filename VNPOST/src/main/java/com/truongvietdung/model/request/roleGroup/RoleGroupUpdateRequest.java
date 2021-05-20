package com.truongvietdung.model.request.roleGroup;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RoleGroupUpdateRequest {
    private int id;
    private String name;
    private String description;
    private List<Integer> roleId;
}
