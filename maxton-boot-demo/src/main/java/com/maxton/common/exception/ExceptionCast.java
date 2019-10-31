package com.maxton.common.exception;


import com.maxton.common.response.ResultCode;

/**
 * @Description 自定义异常类型
 * @author maxton.zhang
 * @Date 2019/10/31 9:16
 * @version 1.0
 */
public class ExceptionCast {

    public static void cast(ResultCode resultCode){
        throw new CustomException(resultCode);
    }
}
