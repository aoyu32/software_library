package com.aoyu.software_library.mapper;


import com.aoyu.software_library.pojo.Software;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SoftwareMapper {


    //添加软件
    @Insert("insert into software(name,size,version,description,icon,create_time,update_time,category_id,status,download_url)" +
            "value(#{name},#{size},#{version},#{description},#{icon},#{createTime},#{updateTime},#{categoryId},#{status},#{downloadUrl})")
    void add(Software software);
}
