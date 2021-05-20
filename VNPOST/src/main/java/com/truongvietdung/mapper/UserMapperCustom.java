package com.truongvietdung.mapper;

import com.truongvietdung.entity.Users;
import com.truongvietdung.model.request.user.UsersSaveRequest;
import com.truongvietdung.model.request.user.UsersUpdateRequest;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Mapper
public abstract class UserMapperCustom {

    @AfterMapping
    public void convertPassword(@MappingTarget Users users){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        users.setPassword(passwordEncoder.encode(users.getPassword()));
    }

    public abstract Users convertSave(UsersSaveRequest usersSaveRequest);

    public abstract Users convertUpdate(UsersUpdateRequest usersUpdateRequest);
}
