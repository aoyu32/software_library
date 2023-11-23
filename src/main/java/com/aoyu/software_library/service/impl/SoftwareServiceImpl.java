package com.aoyu.software_library.service.impl;

import com.aoyu.software_library.mapper.SoftwareMapper;
import com.aoyu.software_library.pojo.Software;
import com.aoyu.software_library.service.SoftwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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

    @Override
    public void add(Software software) {
        //设置软件参数
        //设置添加时间
        software.setCreateTime(LocalDateTime.now());
        software.setUpdateTime(LocalDateTime.now());

        softwareMapper.add(software);
    }
}
