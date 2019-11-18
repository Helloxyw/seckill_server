package com.xyw.seckill_server.redis;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Ricardo
 * @version 1.0.0
 * @ClassName RedisConfig.java
 * @Description TODO
 * @createTime 2019年11月17日 12:19:00
 */
@Component
@Data
@ToString
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfig {
    private String host;
    private int port;
    //秒
    private int timeout;
    private String password;
    private int poolMaxTotal;
    private int maxIdle;
    //秒
    private int poolMaxWait;
}