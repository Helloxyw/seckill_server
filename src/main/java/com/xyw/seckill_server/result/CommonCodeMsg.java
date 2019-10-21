package com.xyw.seckill_server.result;

import lombok.Data;

@Data
public class CommonCodeMsg {
    private String code;
    private String msg;

    public CommonCodeMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static final CommonCodeMsg SUCCESS = new CommonCodeMsg("0000","成功");

    public static final CommonCodeMsg SERVER_ERROR = new CommonCodeMsg("500100","服务端异常");

}
