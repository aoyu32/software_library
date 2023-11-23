package com.aoyu.software_library.pojo;

import com.aoyu.software_library.anno.SoftwareValidation;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;

/**
 * @BelongsProject: software_library
 * @BelongsPackage: com.aoyu.software_library.pojo
 * @Author: AoYu
 * @CreateTime: 2023-11-14  23:14
 * @Description: 软件类
 * @Version: 1.0
 */

@Data
@SoftwareValidation
public class Software {

    private Integer id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String size;

    @NotEmpty
    private String version;

    @NotEmpty
    private String description;

    @NotEmpty
    @URL
    private String icon;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    @NotNull
    private Integer categoryId;
    @NotEmpty

    private String status;
    @NotEmpty
    @URL
    private String downloadUrl;
}
