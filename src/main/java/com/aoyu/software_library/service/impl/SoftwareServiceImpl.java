package com.aoyu.software_library.service.impl;

import com.aoyu.software_library.mapper.SoftwareMapper;
import com.aoyu.software_library.pojo.PageBean;
import com.aoyu.software_library.pojo.Software;
import com.aoyu.software_library.service.SoftwareService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @BelongsProject: software_library
 * @BelongsPackage: com.aoyu.software_library.service.impl
 * @Author: AoYu
 * @CreateTime: 2023-11-23  14:56
 * @Description: 软件管理服务层
 * @Version: 1.0
 */

@Service
public class SoftwareServiceImpl implements SoftwareService {

    @Autowired
    SoftwareMapper softwareMapper;

    //添加软件
    @Override
    public void add(Software software) {
        //设置软件参数
        //设置添加时间
        software.setCreateTime(LocalDateTime.now());
        software.setUpdateTime(LocalDateTime.now());

        softwareMapper.add(software);
    }

    //条件分页查询软软件
    @Override
    public PageBean<Software> query(Integer pageNum, Integer pageSize, String name, Integer categoryId, String status) {

        //创建PageBean对象
        PageBean<Software> pageBean = new PageBean<>();

        //开启分页查询
        PageHelper.startPage(pageNum,pageSize);

        //调用mapper
        List<Software> sl = softwareMapper.query(name,categoryId,status);

        //获取PagerHelper分页查询后得到的总记录条数和当前页数据
        Page<Software> p = (Page<Software>) sl;

        //把数据填充到PageBean对象中
        pageBean.setTotal(p.getTotal());
        pageBean.setItems(p.getResult());

        return pageBean;
    }

    //修改软件信息
    @Override
    public void update(Software software) {

        //设置更新时间
        software.setUpdateTime(LocalDateTime.now());
        softwareMapper.update(software);

    }

    //删除软件
    @Override
    public void delete(Integer id) {
        softwareMapper.delete(id);
    }
}
