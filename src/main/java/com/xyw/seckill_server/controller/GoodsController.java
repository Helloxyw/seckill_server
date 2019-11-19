package com.xyw.seckill_server.controller;

import com.xyw.seckill_server.domain.MiaoshaUser;
import com.xyw.seckill_server.redis.RedisService;
import com.xyw.seckill_server.redis.key.GoodsKey;
import com.xyw.seckill_server.service.intf.GoodsService;
import com.xyw.seckill_server.service.intf.MiaoshaUserService;
import com.xyw.seckill_server.vo.GoodsVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Ricardo
 * @version 1.0.0
 * @ClassName GoodsController.java
 * @Description 商品
 * @createTime 2019年10月26日 23:44:00
 */
@Controller
@RequestMapping("goods")
@Slf4j
public class GoodsController {

    @Autowired
    private MiaoshaUserService miaoshaUserService;

    @Autowired
    private RedisService redisService;

    @Autowired
    private ThymeleafViewResolver thymeleafViewResolver;

    @Autowired
    private GoodsService goodsService;


    public String list(HttpServletRequest request, HttpServletResponse response,
                       Model model, MiaoshaUser miaoshaUser) {
        model.addAttribute("user", miaoshaUser);

        List<GoodsVo> goodsVoList = goodsService.listGoodsVo();
        model.addAttribute("goodsList", goodsVoList);

        WebContext webContext = new WebContext(request, response, request.getServletContext(),
                request.getLocale(), model.asMap());

        //手动渲染
        String html = thymeleafViewResolver.getTemplateEngine().process("goods_list", webContext);
        if (StringUtils.isEmpty(html)) {
            redisService.set(GoodsKey.getGoodsList, "", html);
        }
        return html;
    }

}