package com.truongvietdung.validate;

import com.truongvietdung.entity.DetailService;
import com.truongvietdung.model.request.detailService.DetailServiceSaveRequest;
import com.truongvietdung.model.request.detailService.DetailServiceUpdateRequest;
import com.truongvietdung.model.request.user.UsersSaveRequest;
import com.truongvietdung.model.request.user.UsersUpdateRequest;
import org.apache.commons.lang3.StringUtils;

public class DetailServiceValidate {

    public static DetailServiceSaveRequest validateObjectSave(DetailServiceSaveRequest detailServiceSaveRequest){
        return Validator.of(detailServiceSaveRequest)
                .validate(DetailServiceSaveRequest::getTitle, DetailServiceValidate::checkTitleIsBlank,()->new RuntimeException("Title not null"))
                .validate(DetailServiceSaveRequest::getContent, DetailServiceValidate::checkContentIsBlank,()-> new RuntimeException("Content not null"))
                .validate(DetailServiceSaveRequest::getThumbnail, DetailServiceValidate::checkThumbnailIsBlank,()->new RuntimeException("Thumbnail not null"))
                .validate(DetailServiceSaveRequest::getDescription, DetailServiceValidate::checkDescriptionIsBlank,()->new RuntimeException("Description not null"))
                .get();
    }

    public static DetailServiceUpdateRequest validateObjectSave(DetailServiceUpdateRequest detailServiceUpdateRequest){
        return Validator.of(detailServiceUpdateRequest)
                .validate(DetailServiceUpdateRequest::getTitle, DetailServiceValidate::checkTitleIsBlank,()->new RuntimeException("Title not null"))
                .validate(DetailServiceUpdateRequest::getContent, DetailServiceValidate::checkContentIsBlank,()-> new RuntimeException("Content not null"))
                .validate(DetailServiceUpdateRequest::getThumbnail, DetailServiceValidate::checkThumbnailIsBlank,()->new RuntimeException("Thumbnail not null"))
                .validate(DetailServiceUpdateRequest::getDescription, DetailServiceValidate::checkDescriptionIsBlank,()->new RuntimeException("Description not null"))
                .get();
    }

    private static boolean checkTitleIsBlank(String title){
        return StringUtils.isBlank(title);
    }

    private static boolean checkContentIsBlank(String content){
        return StringUtils.isBlank(content);
    }

    private static boolean checkThumbnailIsBlank(String thumbnail){
        return StringUtils.isBlank(thumbnail);
    }

    private static boolean checkDescriptionIsBlank(String description){
        return StringUtils.isBlank(description);
    }

}
