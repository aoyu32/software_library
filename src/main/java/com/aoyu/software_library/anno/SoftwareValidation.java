package com.aoyu.software_library.anno;

import com.aoyu.software_library.validator.SoftwareValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SoftwareValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SoftwareValidation {
    String message() default "参数规则校验失败!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
