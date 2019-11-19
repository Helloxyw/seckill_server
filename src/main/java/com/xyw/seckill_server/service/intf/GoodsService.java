package com.xyw.seckill_server.service.intf;

import com.xyw.seckill_server.vo.GoodsVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ricardo
 * @version 1.0.0
 * @ClassName GoodsService.java
 * @Description TODO
 * @createTime 2019年11月19日 22:31:00
 */
public interface GoodsService {
    List<GoodsVo> listGoodsVo();

    GoodsVo getGoodsVoByGoodsId(String goodsId);

    boolean reduceStock(GoodsVo goodsVo);

    void resetStock(List<GoodsVo> goodsVoList);

}