package com.xyw.seckill_server.exception;

import com.xyw.seckill_server.result.CommonCodeMsg;
import com.xyw.seckill_server.result.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Ricardo
 * @version 1.0.0
 * @ClassName GlobalExceptionHandler.java
 * @Description 异常处理
 * @createTime 2019年10月28日 23:20:00
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    public CommonResult<String> exceptionHandler(HttpServletRequest request,Exception e){
        log.error(e.getMessage());
        if(e instanceof GlobalException){
           GlobalException ex = (GlobalException) e;
           return CommonResult.error(ex.getCommonCodeMsg());
        }else if(e instanceof BindException){
            BindException ex = (BindException) e;
            List<ObjectError> errors = ex.getAllErrors();
            ObjectError error = errors.get(0);
            String message = error.getDefaultMessage();
            return CommonResult.error(CommonCodeMsg.BIND_ERROR.fillArgs(message));
        }else{
            return CommonResult.error(CommonCodeMsg.SERVER_ERROR);
        }
    }
}