package com.aoyu.software_library.service.impl;

import com.aoyu.software_library.mapper.CategoryMapper;
import com.aoyu.software_library.pojo.Category;
import com.aoyu.software_library.service.CategoryService;
import com.aoyu.software_library.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
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

    //添加分类
    @Override
    public void add(Category category) {
        //封装category数据
        //设置创建用户id
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        category.setCreateUser(id);
        //设置创建时间
        category.setCreateTime(LocalDateTime.now());
        //设置更新时间
        category.setUpdateTime(LocalDateTime.now());
        categoryMapper.add(category);
    }

    //查询所有分类
    @Override
    public List<Category> list() {

        //通过createUserId查询该用户下的所有分类
        //获取用户id
        Map<String ,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");

        //根据id查询分类
        return categoryMapper.list(id);

    }

    //根据id查询分类详情
    @Override
    public Category findById(Integer id) {
         return categoryMapper.findById(id);
    }

    //更新软件分类
    @Override
    public void update(Category category) {
        //设置更新时间
        category.setUpdateTime(LocalDateTime.now());
        //更新信息
        categoryMapper.update(category);
    }

    //删除软件分类
    @Override
    public void delete(Integer id) {
        categoryMapper.delete(id);
    }


}
