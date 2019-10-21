package com.xyw.seckill_server.result;

import lombok.Data;

/**
 * 公共结果类
 */
@Data
public class CommonResult<T> {
    //默认成功
    private String responseCode = "0000";
    private String responseMsg;

    private T data;

    public static <T> CommonResult<T> success(T data){
        return new CommonResult(data);
    }


    public CommonResult(T data) {
        this.data = data;
    }
}
