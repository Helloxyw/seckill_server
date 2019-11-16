package com.xyw.seckill_server.redis.key;

import lombok.Data;

/**
 * @author Ricardo
 * @version 1.0.0
 * @ClassName BaseKeyPrefix.java
 * @Description TODO
 * @createTime 2019年11月16日 15:22:00
 */
@Data
public class BaseKeyPrefix implements KeyPrefix {

    private String prefix;

    private int expireSecond;

    public BaseKeyPrefix(String prefix) {
        this(prefix, 0);
    }

    public BaseKeyPrefix(String prefix, Integer expireSecond) {
        this.prefix = prefix;
        this.expireSecond = expireSecond;
    }

    @Override
    public int expireSeconds() {
        return expireSecond;
    }

    @Override
    public String getPrefix() {
        String className = getClass().getSimpleName();
        return className + ":" + prefix;
    }
}