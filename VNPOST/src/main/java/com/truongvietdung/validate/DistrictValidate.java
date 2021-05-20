package com.truongvietdung.validate;

import com.truongvietdung.model.request.city.CityUpdateRequest;
import com.truongvietdung.model.request.district.DistrictSaveRequest;
import com.truongvietdung.model.request.district.DistrictUpdateRequest;
import org.apache.commons.lang3.StringUtils;

public class DistrictValidate {

    public static DistrictSaveRequest validateObjectSave(DistrictSaveRequest districtSaveRequest){
        return Validator.of(districtSaveRequest)
                .validate(DistrictSaveRequest::getId, DistrictValidate::checkIdIsBlank,()->new RuntimeException("Id not null"))
                .validate(DistrictSaveRequest::getName, DistrictValidate::checkNameIsBlank,()->new RuntimeException("Name not null"))
                .validate(DistrictSaveRequest::getLevel, DistrictValidate::checkLevelIsBlank,()->new RuntimeException("Level not null"))
                .get();
    }

    public static DistrictUpdateRequest validateObjectSave(DistrictUpdateRequest districtUpdateRequest){
        return Validator.of(districtUpdateRequest)
                .validate(DistrictUpdateRequest::getId, DistrictValidate::checkIdIsBlank,()->new RuntimeException("Id not null"))
                .validate(DistrictUpdateRequest::getName, DistrictValidate::checkNameIsBlank,()->new RuntimeException("Name not null"))
                .validate(DistrictUpdateRequest::getLevel, DistrictValidate::checkLevelIsBlank,()->new RuntimeException("Level not null"))
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
