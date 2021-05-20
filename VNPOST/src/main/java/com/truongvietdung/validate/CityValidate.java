package com.truongvietdung.validate;

import com.truongvietdung.model.request.city.CitySaveRequest;
import com.truongvietdung.model.request.city.CityUpdateRequest;
import org.apache.commons.lang3.StringUtils;

public class CityValidate {

    public static CitySaveRequest validateObjectSave(CitySaveRequest citySaveRequest){
        return Validator.of(citySaveRequest)
                .validate(CitySaveRequest::getId, CityValidate::checkIdIsBlank,()->new RuntimeException("Id not null"))
                .validate(CitySaveRequest::getName, CityValidate::checkNameIsBlank,()->new RuntimeException("Name not null"))
                .validate(CitySaveRequest::getLevel, CityValidate::checkLevelIsBlank,()->new RuntimeException("Level not null"))
                .get();
    }

    public static CityUpdateRequest validateObjectSave(CityUpdateRequest cityUpdateRequest){
        return Validator.of(cityUpdateRequest)
                .validate(CityUpdateRequest::getId, CityValidate::checkIdIsBlank,()->new RuntimeException("Id not null"))
                .validate(CityUpdateRequest::getName, CityValidate::checkNameIsBlank,()->new RuntimeException("Name not null"))
                .validate(CityUpdateRequest::getLevel, CityValidate::checkLevelIsBlank,()->new RuntimeException("Level not null"))
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
