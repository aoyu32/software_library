package com.aoyu.software_library.utils;

import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: software_library
 * @BelongsPackage: com.aoyu.software_library.utils
 * @Author: AoYu
 * @CreateTime: 2023-11-23  18:04
 * @Description: TODO
 * @Version: 1.0
 */

public class ValidatorUtils {

    //校验软件名称
    public static boolean isValidName(String value){
        // 添加验证逻辑，例如：检查值是否符合字符数在1~15位
        return value.matches("^\\S{1,15}$");
    }

    //校验软件大小格式
    public static boolean isValidSize(String value) {
        // 添加验证逻辑，例如：检查值是否符合数字后跟KB或MB的格式
        return value.matches("^\\d+(KB|MB)$");
    }

    //校验软件版本格式
    public static boolean isValidVersion(String value) {
        // 添加验证逻辑，例如：检查值是否符合数字和点的格式
        return value.matches("^\\d+(\\.\\d+)+$");
    }

    //校验软件状态字符
    public static boolean isValidStatus(String value) {
        // 添加验证逻辑，例如：检查值是否是允许的状态之一
        List<String> allowedStatusList = Arrays.asList("未破解", "已破解", "免费");
        return allowedStatusList.contains(value);
    }
}
