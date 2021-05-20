package com.truongvietdung.validate.annotation;

import com.truongvietdung.validate.BlogValidate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented // để làm gì ???
@Constraint(validatedBy = BlogValidate.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface BlogConstraint {

    String message() default "Error";
    // trường message là bắt buộc , khai báo nội dung sẽ trả về khi field k hợp lệ

    Class<?>[] groups() default {};
    // cái này là bắt buộc phải có để Hibernate Validator có thể hoạt động

    Class<? extends Payload>[] payload() default {};
    // Cái này là bắt buộc phải có để Hibernate Validator có thể hoạt động
}
