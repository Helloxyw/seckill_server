package com.xyw.seckill_server.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ricardo
 * @version 1.0.0
 * @ClassName ValidatorUtil.java
 * @Description 校验工具
 * @createTime 2019年10月27日 00:03:00
 */
public class ValidatorUtil {
    private static final Pattern mobile_pattern = Pattern.compile("1\\d{10}");

    /***
    * @Description: 检验是否是手机号
    * @Param: [src]
    * @return: boolean
    * @Date: 2019/10/27
    */
    public static boolean isMobile(String src){
        if (StringUtils.isEmpty(src)) {
            return false;
        }
        Matcher m = mobile_pattern.matcher(src);
        return m.matches();
    }
}