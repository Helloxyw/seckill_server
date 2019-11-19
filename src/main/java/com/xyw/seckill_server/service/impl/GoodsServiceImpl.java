package com.xyw.seckill_server.service.impl;

import com.xyw.seckill_server.dao.GoodsDao;
import com.xyw.seckill_server.service.intf.GoodsService;
import com.xyw.seckill_server.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ricardo
 * @version 1.0.0
 * @ClassName GoodsServiceImpl.java
 * @Description TODO
 * @createTime 2019年11月19日 22:33:00
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<GoodsVo> listGoodsVo() {
        return null;
    }

    @Override
    public GoodsVo getGoodsVoByGoodsId(String goodsId) {
        return null;
    }

    @Override
    public boolean reduceStock(GoodsVo goodsVo) {
        return false;
    }

    @Override
    public void resetStock(List<GoodsVo> goodsVoList) {

    }
}