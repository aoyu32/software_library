package com.aoyu.software_library.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
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

    private Integer id;
    @NotEmpty//设置参数不能为null
    private String categoryName;
    @NotEmpty//设置参数不能为null
    private String categoryAlias;
    private Integer createUserId;
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private LocalDateTime updateTime;
}
