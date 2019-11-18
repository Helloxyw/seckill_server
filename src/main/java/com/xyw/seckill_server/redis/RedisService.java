package com.xyw.seckill_server.redis;

import com.alibaba.fastjson.JSONObject;
import com.xyw.seckill_server.redis.key.KeyPrefix;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author Ricardo
 * @version 1.0.0
 * @ClassName RedisService.java
 * @Description TODO
 * @createTime 2019年11月16日 15:10:00
 */
@Service
public class RedisService {

    @Autowired
    JedisPool jedisPool;

    /***
     * @Description: 获取key值对应的对象
     * @Param: [keyPrefix, key, clazz]
     * @return: T
     * @Date: 2019/11/16
     */
    public <T> T get(KeyPrefix keyPrefix, String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            //生成真正的key
            String realKey = keyPrefix.getPrefix() + key;
            String str = jedis.get(realKey);
            T t = stringToBean(str, clazz);
            return t;
        } finally {
            returnToPool(jedis);
        }
    }

    /***
    * @Description: 设值
    * @Param: [keyPrefix, key, value]
    * @return: boolean
    * @Date: 2019/11/16
    */
    public <T> boolean set(KeyPrefix keyPrefix, String key, T value) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String str = beanToString(value);
            if(StringUtils.isEmpty(str)){
                return false;
            }
            //生成真正的key
            String realKey = keyPrefix + key;
            int seconds = keyPrefix.expireSeconds();
            if (seconds <= 0){
                jedis.set(realKey,str);
            }else{
                jedis.setex(realKey,seconds,str);
            }
            return true;
        } finally {
            returnToPool(jedis);
        }
    }

    public static <T> T stringToBean(String str, Class<T> clazz) {
        if (StringUtils.isEmpty(str) || clazz == null) {
            return null;
        }
        if (clazz == int.class || clazz == Integer.class) {
            return (T) Integer.valueOf(str);
        }
        if (clazz == String.class) {
            return (T) str;
        }
        if (clazz == long.class || clazz == Long.class) {
            return (T) Long.valueOf(str);
        }
        return JSONObject.parseObject(str, clazz);
    }

    public static <T> String beanToString(T value) {
        if (value == null) {
            return null;
        }
        Class clazz = value.getClass();
        if (clazz == int.class || clazz == Integer.class) {
            return "" + value;
        }
        if (clazz == String.class) {
            return (String) value;
        }
        if (clazz == long.class || clazz == Long.class) {
            return "" + value;
        }
        return JSONObject.toJSONString(value);
    }

    public void returnToPool(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

}