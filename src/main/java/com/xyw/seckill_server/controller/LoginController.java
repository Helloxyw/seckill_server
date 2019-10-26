package com.xyw.seckill_server.controller;

import com.xyw.seckill_server.result.CommonResult;
import com.xyw.seckill_server.vo.LoginVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@Controller
@RequestMapping("login")
@Slf4j
public class LoginController {

    
    /**
    * @Description: 跳转登陆
    * @Param: []
    * @return: java.lang.String
    * @Date: 2019/10/26
    */
    @RequestMapping("/to_login")
    public String toLogin(){
        //可以记录用户访问次数
        return "login";
    }

    /**
    * @Description: 登录
    * @Param: [response, loginVo]
    * @return: com.xyw.seckill_server.result.CommonResult<java.lang.String>
    * @Date: 2019/10/26
    */
    @RequestMapping("do_login")
    @ResponseBody
    public CommonResult<String> doLogin(HttpServletResponse response, @Valid LoginVo loginVo){

        return CommonResult.success(null);
    }

}
