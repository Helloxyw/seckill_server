package com.xyw.seckill_server.service.intf;

import com.xyw.seckill_server.vo.LoginVo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

/**
 * @author Ricardo
 * @version 1.0.0
 * @ClassName UserService.java
 * @Description 用户接口
 * @createTime 2019年10月28日 22:50:00
 */
@Service
public interface MiaoshaUserService {

    /***
    * @Description: 登录
    * @Param: [response, loginVo]
    * @return: java.lang.String
    * @Date: 2019/10/28
    */
    String login(HttpServletResponse response, LoginVo loginVo);


}
