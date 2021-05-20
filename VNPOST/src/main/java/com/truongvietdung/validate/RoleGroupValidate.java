package com.truongvietdung.validate;

import com.truongvietdung.model.request.roleGroup.RoleGroupSaveRequest;
import com.truongvietdung.model.request.roleGroup.RoleGroupUpdateRequest;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

public class RoleGroupValidate {
    private String name;
    private List<Integer> roleId;

    public static RoleGroupSaveRequest validateObjectSave(RoleGroupSaveRequest  roleGroupSaveRequest){
        return Validator.of(roleGroupSaveRequest)
                .validate(RoleGroupSaveRequest::getName, RoleGroupValidate::checkNameIsBlank ,()->new RuntimeException("Name not null"))
                .validate(RoleGroupSaveRequest::getRoleId, RoleGroupValidate::checkRoleIdIsBlank , ()->new RuntimeException("RoleId not null"))
                .get();
    }

    public static RoleGroupUpdateRequest validateObjectSave(RoleGroupUpdateRequest  roleGroupUpdateRequest){
        return Validator.of(roleGroupUpdateRequest)
                .validate(RoleGroupUpdateRequest::getName, RoleGroupValidate::checkNameIsBlank ,()->new RuntimeException("Name not null"))
                .validate(RoleGroupUpdateRequest::getRoleId, RoleGroupValidate::checkRoleIdIsBlank , ()->new RuntimeException("RoleId not null"))
                .get();
    }

    private static boolean checkNameIsBlank(String name){
        return StringUtils.isBlank(name);
    }

    private static boolean checkRoleIdIsBlank(List<Integer> roleId){
        return roleId.size() == 0;
    }
}
