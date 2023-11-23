package com.aoyu.software_library.validator;

import com.aoyu.software_library.anno.SoftwareValidation;
import com.aoyu.software_library.pojo.Software;
import com.aoyu.software_library.utils.ValidatorUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * @BelongsProject: software_library
 * @BelongsPackage: com.aoyu.software_library.validator
 * @Author: AoYu
 * @CreateTime: 2023-11-23  18:02
 * @Description: 参数校验器
 * @Version: 1.0
 */

public class SoftwareValidator implements ConstraintValidator<SoftwareValidation, Software> {
    @Override
    public boolean isValid(Software software, ConstraintValidatorContext constraintValidatorContext) {
        return  ValidatorUtils.isValidName(software.getName()) &&
                ValidatorUtils.isValidSize(software.getSize()) &&
                ValidatorUtils.isValidVersion(software.getVersion()) &&
                ValidatorUtils.isValidStatus(software.getStatus());
    }
}
