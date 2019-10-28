package com.xyw.seckill_server.result;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CommonCodeMsg {
    private String code;
    private String msg;

    public static final CommonCodeMsg SUCCESS = new CommonCodeMsg("0000","成功");

    public static final CommonCodeMsg SERVER_ERROR = new CommonCodeMsg("500100","服务端异常");
    public static final CommonCodeMsg BIND_ERROR = new CommonCodeMsg("500101","参数校验异常:%s");

    public CommonCodeMsg(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CommonCodeMsg fillArgs(Object... args){
        String code = this.code;
        String message = String.format(this.msg,args);
        return new CommonCodeMsg(code,message);
    }


}
