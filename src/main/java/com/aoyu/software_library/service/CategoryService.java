package com.aoyu.software_library.service;

import com.aoyu.software_library.pojo.Category;

import java.util.List;

public interface CategoryService {

    //添加软件分类
    void add(Category category);

    //查询所有软件分类列表
    List<Category> list();

    //根据分类id查询软件分类详情
    Category findById(Integer id);

    //更新软件分类
    void update(Category category);

    //根据分类id删除软件分类
    void delete(Integer id);
}
