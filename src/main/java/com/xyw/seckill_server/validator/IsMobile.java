package com.xyw.seckill_server.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Ricardo
 * @version 1.0.0
 * @ClassName IsMobile.java
 * @Description 自定义注解
 * @createTime 2019年10月26日 23:45:00
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {IsMobileValidator.class})
public @interface IsMobile {
    boolean required() default true;

    String message() default "手机号码错误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
