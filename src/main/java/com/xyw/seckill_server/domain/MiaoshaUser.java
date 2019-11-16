package com.xyw.seckill_server.domain;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

/**
 * @author Ricardo
 * @version 1.0.0
 * @ClassName MiaoshaUser.java
 * @Description 秒杀用户实体类
 * @createTime 2019年11月16日 15:03:00
 */
@Data
@ToString
public class MiaoshaUser {

    private String id;
    private String nickname;
    private String password;
    private String salt;
    private Date registerDate;
    private Date lastLoginDate;
    private Integer loginCount;

}