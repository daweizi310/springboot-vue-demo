package com.maxton.common.exception;


import com.maxton.common.response.ResultCode;

/**
 * @Description 自定义异常类型
 * @author maxton.zhang
 * @Date 2019/10/31 9:16
 * @version 1.0
 */
public class CustomException extends RuntimeException {

    //错误代码
    ResultCode resultCode;

    public CustomException(ResultCode resultCode){
        this.resultCode = resultCode;
    }
    public ResultCode getResultCode(){
        return resultCode;
    }


}
