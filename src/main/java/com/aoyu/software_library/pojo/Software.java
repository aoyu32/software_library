package com.aoyu.software_library.pojo;

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
public class Software {
    private Integer id;
    @NotEmpty
    @Pattern(regexp = "^\\S{1,15}$")//参数校验
    private String name;
    @NotEmpty
    @Pattern(regexp = "^\\d+(KB|MB)$")
    private String size;
    @NotEmpty
    @Pattern(regexp = "^\\d+(\\.\\d+)+$")
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
    @Pattern(regexp = "^(未破解|已破解|免费)$")
    private String status;
    @NotEmpty
    @URL
    private String downloadUrl;
}
