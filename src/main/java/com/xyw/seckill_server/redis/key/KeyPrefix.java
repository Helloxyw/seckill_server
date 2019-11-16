package com.xyw.seckill_server.redis.key;

/**
 * @author Ricardo
 * @version 1.0.0
 * @ClassName KeyPrefix.java
 * @Description redis key值前缀service
 * @createTime 2019年11月16日 15:17:00
 */
public interface KeyPrefix {
    int expireSeconds();

    String getPrefix();
}
