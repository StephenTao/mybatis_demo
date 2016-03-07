package com.stephen.mybatis.util;

public class StringUtil {

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty() || str.equalsIgnoreCase("null");
    }

}
