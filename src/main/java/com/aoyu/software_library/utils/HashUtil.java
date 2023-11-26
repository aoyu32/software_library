package com.aoyu.software_library.utils;

import org.mindrot.jbcrypt.BCrypt;

/**
 * @BelongsProject: software_library
 * @BelongsPackage: com.aoyu.software_library.utils
 * @Author: AoYu
 * @CreateTime: 2023-11-15  12:51
 * @Description: 密码hash加密类
 * @Version: 1.0
 */

public class HashUtil {

    // 生成加密后的密码
    public static String hashPassword(String plainTextPassword) {
        // 生成盐值
        String salt = BCrypt.gensalt();

        // 使用盐值和密码生成哈希密码
        return BCrypt.hashpw(plainTextPassword, salt);
    }

    // 验证密码是否匹配
    public static boolean verifyPassword(String plainTextPassword, String hashedPassword) {
        // 使用哈希密码进行验证
        return BCrypt.checkpw(plainTextPassword, hashedPassword);
    }
}
