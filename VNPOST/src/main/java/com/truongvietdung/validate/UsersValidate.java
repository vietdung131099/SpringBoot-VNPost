package com.truongvietdung.validate;

import com.truongvietdung.model.request.user.UsersSaveRequest;
import com.truongvietdung.model.request.user.UsersUpdateRequest;
import org.apache.commons.lang3.StringUtils;

public class UsersValidate {

    public static UsersSaveRequest validateObjectSave(UsersSaveRequest usersSaveRequest){
        return Validator.of(usersSaveRequest)
                .validate(UsersSaveRequest::getUserName, UsersValidate::checkUserNameIsBlank,()->new RuntimeException("UserName not null"))
                .validate(UsersSaveRequest::getPassword, UsersValidate::checkPasswordIsBlank, ()->new RuntimeException("Password not null"))
                .validate(UsersSaveRequest::getEmail, UsersValidate::checkEmailIsBlank, ()->new RuntimeException("Email not null"))
                .validate(UsersSaveRequest::getPhone, UsersValidate::checkPhoneIsBlank, ()->new RuntimeException("Phone not null"))
                .validate(UsersSaveRequest::getAddress, UsersValidate::checkAddressIsBlank, ()->new RuntimeException("Address not null"))
                .validate(UsersSaveRequest::getFullName, UsersValidate::checkFullNameIsBlank, ()->new RuntimeException("FullName not null"))
                .get();
    }

    public static UsersUpdateRequest validateObjectSave(UsersUpdateRequest usersUpdateRequest){
        return Validator.of(usersUpdateRequest)
                .validate(UsersUpdateRequest::getUserName, UsersValidate::checkUserNameIsBlank,()->new RuntimeException("UserName not null"))
                .validate(UsersUpdateRequest::getPassword, UsersValidate::checkPasswordIsBlank, ()->new RuntimeException("Password not null"))
                .validate(UsersUpdateRequest::getEmail, UsersValidate::checkEmailIsBlank, ()->new RuntimeException("Email not null"))
                .validate(UsersUpdateRequest::getPhone, UsersValidate::checkPhoneIsBlank, ()->new RuntimeException("Phone not null"))
                .validate(UsersUpdateRequest::getAddress, UsersValidate::checkAddressIsBlank, ()->new RuntimeException("Address not null"))
                .validate(UsersUpdateRequest::getFullName, UsersValidate::checkFullNameIsBlank, ()->new RuntimeException("FullName not null"))
                .get();
    }

    private static boolean checkUserNameIsBlank(String userName){
        return StringUtils.isBlank(userName);
    }

    private static boolean checkPasswordIsBlank(String password){
        return StringUtils.isBlank(password);
    }

    private static boolean checkEmailIsBlank(String email){
        return StringUtils.isBlank(email);
    }

    private static boolean checkPhoneIsBlank(String phone){
        return StringUtils.isBlank(phone);
    }

    private static boolean checkAddressIsBlank(String address){
        return StringUtils.isBlank(address);
    }

    private static boolean checkFullNameIsBlank(String fullName){
        return StringUtils.isBlank(fullName);
    }
}
