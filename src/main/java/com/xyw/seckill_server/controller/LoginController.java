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


    @RequestMapping("/to_login")
    public String toLogin(){
        //可以记录用户访问次数
        return "login";
    }

    @RequestMapping("do_login")
    @ResponseBody
    public CommonResult<String> doLogin(HttpServletResponse response, @Valid LoginVo loginVo){
        return CommonResult.success(null);
    }

}
