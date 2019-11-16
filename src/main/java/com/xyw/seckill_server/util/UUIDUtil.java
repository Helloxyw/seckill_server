package com.xyw.seckill_server.util;

import java.util.UUID;

/**
 * @author Ricardo
 * @version 1.0.0
 * @ClassName UUIDUtil.java
 * @Description TODO
 * @createTime 2019年11月16日 17:00:00
 */
public class UUIDUtil {
    public static String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}