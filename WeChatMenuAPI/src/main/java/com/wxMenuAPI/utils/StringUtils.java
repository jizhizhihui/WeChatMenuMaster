package com.wxMenuAPI.utils;

import java.util.UUID;

public class StringUtils {

    /**
     * 生成随记字符串
     * @return
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
