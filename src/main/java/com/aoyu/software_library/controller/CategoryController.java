package com.aoyu.software_library.controller;

import com.aoyu.software_library.pojo.Category;
import com.aoyu.software_library.pojo.Result;
import com.aoyu.software_library.service.impl.CategoryServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @BelongsProject: software_library
 * @BelongsPackage: com.aoyu.software_library.controller
 * @Author: AoYu
 * @CreateTime: 2023-11-22  16:50
 * @Description: 软件分类控制器
 * @Version: 1.0
 */


@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryServiceImpl categoryService;

    //新增软件分类
    @Operation(summary = "添加分类")
    @PostMapping("/add")
    public Result add(@RequestBody @Validated Category category){
        categoryService.add(category);
        return Result.success();
    }

    //查询分类列表
    @Operation(summary = "分类列表")
    @GetMapping("/list")
    public Result<List<Category>> list(){
        List<Category> list = categoryService.list();
        return Result.success(list);
    }

    //查询分类详情
    @Operation(summary = "分类详情")
    @GetMapping("/detail")
    public Result<Category> detail(Integer id) {
        Category c = categoryService.findById(id);
        return Result.success(c);
    }




}
