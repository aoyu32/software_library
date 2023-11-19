package com.aoyu.software_library.utils;

/**
 * @BelongsProject: software_library
 * @BelongsPackage: com.aoyu.software_library.utils
 * @Author: AoYu
 * @CreateTime: 2023-11-19  16:34
 * @Description: TODO
 * @Version: 1.0
 */

public class ThreadLocalUtil {

    private static final ThreadLocal THREAD_LOCAL=  new ThreadLocal<>();

    /**
     * 设置ThreadLocal中的值
     */
    public static void set(Object value) {
        THREAD_LOCAL.set(value);
    }

    /**
     * 获取ThreadLocal中的值
     * @return 值
     */
    public static <T> T get() {
        return (T) THREAD_LOCAL.get();
    }

    /**
     * 清除ThreadLocal中的值
     */
    public static void clear() {
        THREAD_LOCAL.remove();
    }
}

