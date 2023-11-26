package com.aoyu.software_library.service;

import com.aoyu.software_library.pojo.PageBean;
import com.aoyu.software_library.pojo.Software;

public interface SoftwareService {
    //添加软件
    void add(Software software);

    //条件分页查询软件
    PageBean<Software> query(Integer pageNum, Integer pageSize, String name, Integer categoryId, String status);

}
