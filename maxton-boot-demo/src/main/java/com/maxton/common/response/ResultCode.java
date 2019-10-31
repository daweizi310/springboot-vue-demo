package com.maxton.common.response;

/**
 * @Description 统一返回格式
 * @Author maxton.zhang
 * @Date 2019/10/31 9:16
 * @Version 1.0
 */
public interface ResultCode {
    //操作是否成功,true为成功，false操作失败
    boolean flag();

    //操作代码
    int code();

    //提示信息
    String message();
}
