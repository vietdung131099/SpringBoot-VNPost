package com.truongvietdung.model.request.user;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UsersSaveRequest {
    private String userName;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String fullName;
    private List<Integer> roleGroupIds;
}
