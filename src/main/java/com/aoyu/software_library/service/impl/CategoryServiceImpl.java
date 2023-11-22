package com.aoyu.software_library.service.impl;

import com.aoyu.software_library.mapper.CategoryMapper;
import com.aoyu.software_library.pojo.Category;
import com.aoyu.software_library.service.CategoryService;
import com.aoyu.software_library.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * @BelongsProject: software_library
 * @BelongsPackage: com.aoyu.software_library.service
 * @Author: AoYu
 * @CreateTime: 2023-11-22  17:05
 * @Description: 软件分类服务层
 * @Version: 1.0
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public void add(Category category) {
        //封装category数据
        //设置创建用户id
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        category.setCreateUserId(id);
        //设置创建时间
        category.setCreateTime(LocalDateTime.now());
        //设置更新时间
        category.setUpdateTime(LocalDateTime.now());
        categoryMapper.add(category);
    }

    //添加软件分类

}
