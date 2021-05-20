package com.truongvietdung.validate;

import com.truongvietdung.validate.annotation.BlogConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BlogValidate implements ConstraintValidator<BlogConstraint,String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {

        if(s==null || s.isEmpty())
            return false;
        return false;
    }
}
