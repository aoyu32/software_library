package com.aoyu.software_library.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalDateTime;

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
    @JsonIgnore//让springmvc把当前对象转换成json字符串时忽略password,最终的json字符串就没有password属性了
    private String password;
    private String nickname;
    private String email;
    private String userPic;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
