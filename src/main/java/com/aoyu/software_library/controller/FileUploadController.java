package com.aoyu.software_library.controller;

import com.aoyu.software_library.pojo.Result;
import com.aoyu.software_library.utils.AliOssUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.util.UUID;

/**
 * @BelongsProject: software_library
 * @BelongsPackage: com.aoyu.software_library.controller
 * @Author: AoYu
 * @CreateTime: 2023-11-26  14:34
 * @Description: TODO
 * @Version: 1.0
 */

@Tag(name = "文件上传")
@RestController
@RequestMapping("/upload")
public class FileUploadController {

    //上传头像
    @Operation(summary = "上传头像")
    @PostMapping("/avatar")
    public Result<String> avatar(MultipartFile file) throws Exception {
        //获取源文件名称
        String originFileName = file.getOriginalFilename();
        //保证文件名称唯一
        String fileName = UUID.randomUUID().toString()+originFileName.substring(originFileName.lastIndexOf("."));

        //上传文件
        String url = AliOssUtil.uploadFile(fileName,file.getInputStream());

        return Result.success(url);
    }

}
