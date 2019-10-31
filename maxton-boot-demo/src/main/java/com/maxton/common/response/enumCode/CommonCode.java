package com.maxton.common.response.enumCode;

import com.maxton.common.response.ResultCode;
import lombok.ToString;

/**
 * @Description 统一CommonCode
 * @Author maxton.zhang
 * @Date 2019/10/31 9:56
 * @Version 1.0
 */
@ToString
public enum CommonCode implements ResultCode {
    SUCCESS(true, 10000, "操作成功！"),
    QUERY_SUCCESS(true, 10000, "查询成功"),
    CREATE_SUCCESS(true, 10000, "新增成功"),
    UPDATE_SUCCESS(true, 10000, "修改成功"),
    DELETE_SUCCESS(true, 10000, "删除成功"),
    EXPORT_SUCCESS(true, 10000, "导出成功"),
    ERROR(false, 30001, "操作失败！"),
    QUERY_ERROR(false, 30002, "查询失败！"),
    DATA_IS_WRONG(false, 30003, "数据有误！"),
    DATA_ALREADY_EXISTED(false, 30004, "重复录入数据,请检查后重试！"),
    DATA_IS_NULL(false, 30005, "数据不能为空,请检查后重试！"),
    INVALID_CAST(false, 30006, "类型转换错误,请检查后重试！"),
    INVALID_FILE_IO(false, 30007, "文件导入或导出失败！"),
    INVALID_PARAM(false, 30008, "非法参数！"),
    PATH_IS_ERROR(false, 30009, "请输入正确的路径！"),
    VERSION_PATH_IS_ERROR(false, 300010, "测试版本不存在,请检查版本路径是否正确！"),
    SERVER_ERROR(false, 99999, "抱歉，系统繁忙，请稍后重试！");

    //操作是否成功
    boolean flag;
    //操作代码
    int code;
    //提示信息
    String message;

    CommonCode(boolean flag, int code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean flag() {
        return flag;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
