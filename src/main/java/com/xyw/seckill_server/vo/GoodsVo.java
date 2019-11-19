package com.xyw.seckill_server.vo;

import com.xyw.seckill_server.domain.Goods;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author Ricardo
 * @version 1.0.0
 * @ClassName GoodsVo.java
 * @Description TODO
 * @createTime 2019年11月19日 22:29:00
 */
@Data
@ToString
public class GoodsVo extends Goods {
    private Double miaoshaPrice;
    private Integer stockCount;
    private Date startDate;
    private Date endDate;
}