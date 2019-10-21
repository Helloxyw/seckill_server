package com.xyw.seckill_server.vo;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

@Data
@ToString
public class LoginVo {
    @NotNull
    private String mobile;

}
