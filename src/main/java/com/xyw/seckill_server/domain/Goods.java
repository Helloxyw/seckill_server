package com.xyw.seckill_server.domain;

import lombok.Data;
import lombok.ToString;

/**
 * @author Ricardo
 * @version 1.0.0
 * @ClassName Goods.java
 * @Description TODO
 * @createTime 2019年11月19日 22:29:00
 */
@Data
@ToString
public class Goods {
    private String  id;
    private String goodsName;
    private String goodsTitle;
    private String goodsImg;
    private String goodsDetail;
    private Double goodsPrice;
    private Integer goodsStock;
}