package com.xyw.seckill_server.redis.key;

/**
 * @author Ricardo
 * @version 1.0.0
 * @ClassName GoodsKey.java
 * @Description TODO
 * @createTime 2019年11月19日 22:25:00
 */
public class GoodsKey extends BaseKeyPrefix {

    public GoodsKey(String prefix, Integer expireSecond) {
        super(prefix, expireSecond);
    }

    public static GoodsKey getGoodsList = new GoodsKey("gl", 60);
    public static GoodsKey getGoodsDetail = new GoodsKey("de", 60);
    public static GoodsKey getMiaoshaGoodsStock = new GoodsKey("gs", 0);


}