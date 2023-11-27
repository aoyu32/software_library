package com.aoyu.software_library.mapper;


import com.aoyu.software_library.pojo.Software;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SoftwareMapper {


    //添加软件
    @Insert("insert into software(name,size,version,description,icon,create_time,update_time,category_id,status,download_url)" +
            "value(#{name},#{size},#{version},#{description},#{icon},#{createTime},#{updateTime},#{categoryId},#{status},#{downloadUrl})")
    void add(Software software);

    //条件查询软件
    List<Software> query(String name, Integer categoryId, String status);

    //条件更新软件信息
    void update(Software software);
}
