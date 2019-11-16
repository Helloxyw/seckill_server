package com.xyw.seckill_server.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author Ricardo
 * @version 1.0.0
 * @ClassName MD5Util.java
 * @Description md5加密工具类
 * @createTime 2019年11月16日 16:47:00
 */
public class MD5Util {

    public static String md5(String src) {
        return DigestUtils.md5Hex(src);
    }

    private static final String SALT = "1a2b3c4d";

    public static String formPassToDBPass(String formPass, String salt) {
        String str = "" + salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(5)
                + salt.charAt(4);
        return md5(str);
    }
}