package com.xyw.seckill_server.service.impl;

import com.xyw.seckill_server.dao.MiaoshaUserDao;
import com.xyw.seckill_server.domain.MiaoshaUser;
import com.xyw.seckill_server.exception.GlobalException;
import com.xyw.seckill_server.redis.RedisService;
import com.xyw.seckill_server.redis.key.MiaoshaUserKey;
import com.xyw.seckill_server.result.CommonCodeMsg;
import com.xyw.seckill_server.service.intf.MiaoshaUserService;
import com.xyw.seckill_server.util.MD5Util;
import com.xyw.seckill_server.util.UUIDUtil;
import com.xyw.seckill_server.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author Ricardo
 * @version 1.0.0
 * @ClassName UserServiceImpl.java
 * @Description TODO
 * @createTime 2019年11月11日 21:23:00
 */
@Service
public class MiaoshaUserServiceImpl implements MiaoshaUserService {

    private static final String COOKIE_NAME_TOKEN = "token";

    @Autowired
    private RedisService redisService;

    @Autowired
    private MiaoshaUserDao miaoshaUserDao;

    @Override
    public String login(HttpServletResponse response, LoginVo loginVo) {
        if (loginVo == null) {
            throw new GlobalException(CommonCodeMsg.SERVER_ERROR);
        }
        String mobile = loginVo.getMobile();
        //在前端提交登录表单时  已经做了一次md5加密
        String formPass = loginVo.getPassword();

        //判断手机号是否存在
        MiaoshaUser user = getById(mobile);
        if (user == null) {
            throw new GlobalException(CommonCodeMsg.MOBILE_NOT_EXIST);
        }

        //验证密码
        String dbPass = user.getPassword();
        String dbSalt = user.getSalt();

        String calcPass = MD5Util.formPassToDBPass(formPass, dbSalt);
        if (!calcPass.equals(dbPass)) {
            throw new GlobalException(CommonCodeMsg.PASSWORD_ERROR);
        }
        String token = UUIDUtil.uuid();
        addCookie(response,token,user);
        return token;
    }


    /***
     * @Description: 获取用户   先查缓存，再查库
     * @Param: [id]
     * @return: com.xyw.seckill_server.domain.MiaoshaUser
     * @Date: 2019/11/16
     */
    protected MiaoshaUser getById(String id) {
        //取缓存
        MiaoshaUser user = redisService.get(MiaoshaUserKey.getById, id, MiaoshaUser.class);
        if (user != null) {
            return user;
        }
        //取数据库
        user = miaoshaUserDao.getById(id);
        if (user != null) {
            redisService.set(MiaoshaUserKey.getById, id, user);
        }
        return user;
    }

    public void addCookie(HttpServletResponse response, String token, MiaoshaUser miaoshaUser) {
        redisService.set(MiaoshaUserKey.token, token, miaoshaUser);
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
        cookie.setMaxAge(MiaoshaUserKey.TOKEN_EXPIRE);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}