package com.aoyu.software_library.mapper;

import com.aoyu.software_library.pojo.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryMapper {

    //添加软件分类
    @Insert("insert into category(category_name,category_alias,create_user,create_time,update_time) " +
            "value(#{categoryName},#{categoryAlias},#{createUserId},#{createTime},#{updateTime})")
    void add(Category category);

    //根据createUserId查询所有分类
    @Select("select * from category where create_user=#{userId}")
    List<Category> list(Integer userId);
}
