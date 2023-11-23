package com.aoyu.software_library.mapper;

import com.aoyu.software_library.pojo.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {

    //添加软件分类
    @Insert("insert into category(category_name,category_alias,create_user,create_time,update_time) " +
            "value(#{categoryName},#{categoryAlias},#{createUser},#{createTime},#{updateTime})")
    void add(Category category);

    //根据createUserId查询所有软件分类
    @Select("select * from category where create_user=#{userId}")
    List<Category> list(Integer userId);

    //根据分类id查询软件分类详情
    @Select("select * from category where id=#{id}")
    Category findById(Integer id);

    //更新软件分类信息
    @Update("update category set category_name=#{categoryName},category_alias=#{categoryAlias},update_time=#{updateTime} where id=#{id}")
    void update(Category category);

    //根据id删除软件分类
    @Delete("delete from category where id=#{id}")
    void delete(Integer id);
}
