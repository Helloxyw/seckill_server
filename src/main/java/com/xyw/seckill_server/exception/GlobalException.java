package com.xyw.seckill_server.exception;

import com.xyw.seckill_server.result.CommonCodeMsg;
import lombok.Data;

/**
 * @author Ricardo
 * @version 1.0.0
 * @ClassName GlobalException.java
 * @Description 全局异常处理类
 * @createTime 2019年10月28日 23:12:00
 */
@Data
public class GlobalException extends RuntimeException {
    private static final long serialVersionUID = -5873954531205801970L;

    private CommonCodeMsg commonCodeMsg;

    public GlobalException(CommonCodeMsg commonCodeMsg) {
        super(commonCodeMsg.toString());
        this.commonCodeMsg = commonCodeMsg;
    }
}