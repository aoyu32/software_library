package com.aoyu.software_library.controller;

import com.aoyu.software_library.pojo.Result;
import com.aoyu.software_library.utils.JwtTokenUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @BelongsProject: software_library
 * @BelongsPackage: com.aoyu.software_library.controller
 * @Author: AoYu
 * @CreateTime: 2023-11-19  14:43
 * @Description: TODO
 * @Version: 1.0
 */
@Tag(name = "软件管理")
@RestController
@RequestMapping("/software")
@Validated
public class SoftwareController {

    @Operation(summary = "软件列表")
    @GetMapping("/list")
    public Result<String> list(){
        return Result.success("所有软件列表~~");
    }


}
