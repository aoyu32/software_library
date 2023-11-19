package com.aoyu.software_library.exception;

import com.aoyu.software_library.pojo.Result;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @BelongsProject: software_library
 * @BelongsPackage: com.aoyu.software_library.exception
 * @Author: AoYu
 * @CreateTime: 2023-11-15  20:36
 * @Description: 处理全局异常类
 * @Version: 1.0
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    //处理全局异常
    @ExceptionHandler
    public Result handleException(Exception e){
        //将错误信息输出到控制台
        e.printStackTrace();
        return Result.error(StringUtils.hasLength(e.getMessage())?e.getMessage():"操作失败");
    }

}
