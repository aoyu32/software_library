package com.aoyu.software_library.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
    @NotNull
    private Integer id;
    private String username;
    @JsonIgnore//让springmvc把当前对象转换成json字符串时忽略password,最终的json字符串就没有password属性了
    private String password;

    @NotEmpty//限制nickname不能为空
    @Pattern(regexp = "^\\S{1,10}$")//限制nickname只能1~10个字符
    private String nickname;
    @NotEmpty//限制email不能为空
    @Email//限制必须满足email的格式
    private String email;
    private String userPic;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
