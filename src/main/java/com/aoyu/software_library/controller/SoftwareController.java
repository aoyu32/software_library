package com.aoyu.software_library.controller;

import com.aoyu.software_library.pojo.Result;
import com.aoyu.software_library.pojo.Software;
import com.aoyu.software_library.service.impl.SoftwareServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @BelongsProject: software_library
 * @BelongsPackage: com.aoyu.software_library.controller
 * @Author: AoYu
 * @CreateTime: 2023-11-19  14:43
 * @Description: 软件管理控制器
 * @Version: 1.0
 */
@Tag(name = "软件管理")
@RestController
@RequestMapping("/software")
@Validated
public class SoftwareController {

    @Autowired
    private SoftwareServiceImpl softwareService;

    //添加软件
    @Operation(summary = "添加软件")
    @PostMapping("/add")
    public Result add(@RequestBody @Validated Software software){
        softwareService.add(software);
        return Result.success();

    }

}
