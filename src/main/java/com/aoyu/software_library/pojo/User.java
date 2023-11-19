package com.aoyu.software_library.pojo;

import lombok.Data;

import java.time.LocalDate;

/**
 * @BelongsProject: software_library
 * @BelongsPackage: com.aoyu.software_library.pojo
 * @Author: AoYu
 * @CreateTime: 2023-11-14  23:13
 * @Description: 用户类
 * @Version: 1.0
 */

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String userPic;
    private LocalDate createTime;
    private LocalDate updateTime;
}
