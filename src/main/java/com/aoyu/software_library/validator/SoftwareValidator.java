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
        if (software == null) {
            return false; // Return false if the software object is null
        }

        boolean isValid = true;

        // Validate name if not null
        if (software.getName() != null) {
            isValid = isValid && ValidatorUtils.isValidName(software.getName());
        }

        // Validate size if not null
        if (software.getSize() != null) {
            isValid = isValid && ValidatorUtils.isValidSize(software.getSize());
        }

        // Validate version if not null
        if (software.getVersion() != null) {
            isValid = isValid && ValidatorUtils.isValidVersion(software.getVersion());
        }

        // Validate status if not null
        if (software.getStatus() != null) {
            isValid = isValid && ValidatorUtils.isValidStatus(software.getStatus());
        }

        return isValid;
    }
}
