package com.aoyu.software_library.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @BelongsProject: software_library
 * @BelongsPackage: com.aoyu.software_library.pojo
 * @Author: AoYu
 * @CreateTime: 2023-11-15  12:03
 * @Description: 响应结果类
 * @Version: 1.0
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {

    private Integer code;//响应状态码 0-成功;1-失败;
    private String message;//提示信息
    private T data;//响应数据

    //Return the successful response result of the operation(have response data)
    public static <E> Result<E> success(E data){
        return new Result<E>(0,"操作成功",data);
    }

    //Return the successful response result of the operation(no response data)
    public static Result success(){
        return new Result(0,"操作成功",null);
    }

    //Return error message
    public static Result error(String message){
        return new Result(1,message,null);
    }




}
