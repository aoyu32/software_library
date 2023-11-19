package com.aoyu.software_library.pojo;

import lombok.Data;
import java.time.LocalDate;


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
    private String categoryName;
    private String categoryAlias;
    private Integer createUserId;
    private LocalDate createTime;
    private LocalDate updateTime;
}
