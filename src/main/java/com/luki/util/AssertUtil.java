package com.luki.util;

import com.luki.exception.ParamsException;

/**
 * 工具类
 * 校验类
 */
public class AssertUtil {
    public static void isTrue(boolean flag,String msg){
        //如何为true,则抛出异常
        if (flag){
            throw new ParamsException(msg);
        }
    }
}
