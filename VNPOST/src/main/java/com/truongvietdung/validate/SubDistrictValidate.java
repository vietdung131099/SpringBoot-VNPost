package com.truongvietdung.validate;

import com.truongvietdung.model.request.district.DistrictUpdateRequest;
import com.truongvietdung.model.request.subDistrict.SubDistrictSaveRequest;
import com.truongvietdung.model.request.subDistrict.SubDistrictUpdateRequest;
import org.apache.commons.lang3.StringUtils;

public class SubDistrictValidate {

    public static SubDistrictSaveRequest validateObjectSave(SubDistrictSaveRequest subDistrictSaveRequest){
        return Validator.of(subDistrictSaveRequest)
                .validate(SubDistrictSaveRequest::getId, SubDistrictValidate::checkIdIsBlank,()->new RuntimeException("Id not null"))
                .validate(SubDistrictSaveRequest::getName, SubDistrictValidate::checkNameIsBlank,()->new RuntimeException("Name not null"))
                .validate(SubDistrictSaveRequest::getLevel, SubDistrictValidate::checkLevelIsBlank,()->new RuntimeException("Level not null"))
                .get();
    }


    public static SubDistrictUpdateRequest validateObjectSave(SubDistrictUpdateRequest subDistrictUpdateRequest){
        return Validator.of(subDistrictUpdateRequest)
                .validate(SubDistrictUpdateRequest::getId, SubDistrictValidate::checkIdIsBlank,()->new RuntimeException("Id not null"))
                .validate(SubDistrictUpdateRequest::getName, SubDistrictValidate::checkNameIsBlank,()->new RuntimeException("Name not null"))
                .validate(SubDistrictUpdateRequest::getLevel, SubDistrictValidate::checkLevelIsBlank,()->new RuntimeException("Level not null"))
                .get();
    }

    private static boolean checkIdIsBlank(String id){
        return StringUtils.isBlank(id);
    }

    private static boolean checkNameIsBlank(String name){
        return StringUtils.isBlank(name);
    }

    private static boolean checkNameEnglishIsBlank(String nameEnglish){
        return StringUtils.isBlank(nameEnglish);
    }

    private static boolean checkLevelIsBlank(String level){
        return StringUtils.isBlank(level);
    }
}
