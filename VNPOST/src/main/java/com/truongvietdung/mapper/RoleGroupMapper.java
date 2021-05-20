package com.truongvietdung.mapper;

import com.truongvietdung.entity.RoleGroup;
import com.truongvietdung.model.request.roleGroup.RoleGroupSaveRequest;
import com.truongvietdung.model.request.roleGroup.RoleGroupUpdateRequest;
import org.mapstruct.Mapper;

@Mapper
public interface RoleGroupMapper extends BaseMapper<RoleGroup, RoleGroupSaveRequest, RoleGroupUpdateRequest> {
}
