package com.maxton.common.response;

import com.maxton.common.response.enumCode.CommonCode;
import lombok.Data;
import lombok.ToString;

/**
 * @Description 统一返回类型
 * @Author maxton.zhang
 * @Date 2019/10/31 9:16
 * @Version 1.0
 */
@Data
@ToString
public class ResponseResult implements Response {

    //操作是否成功
    boolean flag = SUCCESS;

    //操作代码
    Integer code = SUCCESS_CODE;

    //提示信息
    String message;
    String msg;

    //查询对象
    Object data;

    public ResponseResult(ResultCode resultCode) {
        this.flag = resultCode.flag();
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.msg = resultCode.message();
    }

    public ResponseResult(ResultCode resultCode, PageResult pageResult) {
        this.flag = resultCode.flag();
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.msg = resultCode.message();
        this.data = pageResult;
    }

    public ResponseResult(ResultCode resultCode, Object data) {
        this.flag = resultCode.flag();
        this.code = resultCode.code();
        this.message = resultCode.message();
        this.msg = resultCode.message();
        this.data = data;
    }

    public ResponseResult(boolean flag, Integer code, String message, PageResult pageResult) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.msg = message;
        this.data = pageResult;
    }

    public ResponseResult(Integer code, String message,Object data) {
        this.code = code;
        this.message = message;
        this.msg = message;
        this.data = data;
    }

    public ResponseResult(boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.msg = message;
        this.data = data;
    }

    public ResponseResult(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.msg = message;
    }

    public static ResponseResult SUCCESS() {
        return new ResponseResult(CommonCode.SUCCESS);
    }

    public static ResponseResult ERROR() {
        return new ResponseResult(CommonCode.ERROR);
    }

}
