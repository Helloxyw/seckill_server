package com.xyw.seckill_server.redis.key;

/**
 * @author Ricardo
 * @version 1.0.0
 * @ClassName MiaoshaUserKey.java
 * @Description 秒杀用户key值
 * @createTime 2019年11月16日 15:48:00
 */
public class MiaoshaUserKey extends BaseKeyPrefix {
    public static final int TOKEN_EXPIRE = 3600 * 24 * 2;

    public static MiaoshaUserKey token = new MiaoshaUserKey("tk", TOKEN_EXPIRE);
    public static MiaoshaUserKey getById = new MiaoshaUserKey("id", 0);

    public MiaoshaUserKey(String prefix, Integer expireSecond) {
        super(prefix, expireSecond);
    }
}