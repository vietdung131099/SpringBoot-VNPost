package com.truongvietdung.mapper;

import com.truongvietdung.entity.Users;
import com.truongvietdung.model.request.user.UsersSaveRequest;
import com.truongvietdung.model.request.user.UsersUpdateRequest;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<Users, UsersSaveRequest, UsersUpdateRequest> {
}
