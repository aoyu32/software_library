package com.aoyu.software_library.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import lombok.Data;
import java.time.LocalDateTime;


/**
 * @BelongsProject: software_library
 * @BelongsPackage: com.aoyu.software_library.pojo
 * @Author: AoYu
 * @CreateTime: 2023-11-14  23:13
 * @Description: 软件类别类
 * @Version: 1.0
 */

@Data
public class Category {

    //设置在更新软件分类信息时id参数不能为空
    @NotNull(groups = Update.class)
    private Integer id;
    @NotEmpty//设置参数不能为null,不指定校验分组默认继承所有校验分组
    private String categoryName;
    @NotEmpty//设置参数不能为null,不指定校验分组默认继承所有校验分组
    private String categoryAlias;
    private Integer createUser;
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private LocalDateTime updateTime;

    //参数分组校验
    //如果说某个校验项没有指定分组，默认属于Default分组
    //分组之间可以继承，A extends B那么A中拥有B中所有的校验项
    public interface Add extends Default {

    }

    public interface Update extends Default{

    }
}
