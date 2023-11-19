package com.aoyu.software_library.pojo;

import lombok.Data;

import java.util.Date;

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
    private String sname;
    private String size;
    private String version;
    private String description;
    private String icon;
    private Date addTime;
    private Date updateTime;
    private Integer categoryId;
}
