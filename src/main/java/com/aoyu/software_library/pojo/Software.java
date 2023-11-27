package com.aoyu.software_library.pojo;

import com.aoyu.software_library.anno.SoftwareValidation;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.groups.Default;
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

    @NotNull(groups = Update.class)
    private Integer id;

    @NotEmpty(groups = Add.class)
    private String name;

    @NotEmpty(groups = Add.class)
    private String size;

    @NotEmpty(groups = Add.class)
    private String version;

//    @NotEmpty
    private String description;

//    @NotEmpty
    @URL
    private String icon;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    @NotNull(groups = Add.class)
    private Integer categoryId;

    @NotEmpty(groups = Add.class)
    private String status;

//    @NotEmpty
    @URL
    private String downloadUrl;

    //参数分组校验
    //如果说某个校验项没有指定分组，默认属于Default分组
    //分组之间可以继承，A extends B那么A中拥有B中所有的校验项
    public interface Add extends Default {

    }

    public interface Update extends Default{

    }
}
