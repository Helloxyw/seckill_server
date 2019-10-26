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

    /**
     * 成功时调用
     * @param data
     * @param <T>
     * @return
     */
    public static <T> CommonResult<T> success(T data){
        return new CommonResult(data);
    }


    /**
     * 失败时调用
     * @param codeMsg
     * @return
     */
    public static CommonResult fail(CommonCodeMsg codeMsg){
        return new CommonResult(codeMsg);
    }


    public CommonResult(T data) {
        this.data = data;
    }
}
