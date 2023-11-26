package com.aoyu.software_library.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @BelongsProject: software_library
 * @BelongsPackage: com.aoyu.software_library.pojo
 * @Author: AoYu
 * @CreateTime: 2023-11-26  13:08
 * @Description: 分页查询封装分页的实体类
 * @Version: 1.0
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean<T> {
    //分页总条数
    private Long total;
    //当前分页数据集合
    private List<T> items;
}
