package com.maxton.common.exception;

import com.google.common.collect.ImmutableMap;
import com.maxton.common.response.ResponseResult;
import com.maxton.common.response.ResultCode;
import com.maxton.common.response.enumCode.CommonCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;


/**
 * @Description 统一异常捕获类
 * @Author maxton.zhang
 * @Date 2019/10/31 9:16
 * @Version 1.0
 */
@ControllerAdvice
@Slf4j
public class ExceptionCatch {

    /**
     * 拦截捕捉异常 DataIntegrityViolationException.class
     *
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseResult MySQLIntegrityConstraintViolationException(DataIntegrityViolationException e) {
        log.info("重复录入数据:{}" + e.getMessage());
        return new ResponseResult(CommonCode.DATA_ALREADY_EXISTED);
    }


    /**
     * 拦截捕捉异常 NullPointerException.class
     *
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = NullPointerException.class)
    public ResponseResult NullPointerExceptionErrorHandler(NullPointerException e) {
        log.info("数据不能不为空:{}", e.getMessage());
        return new ResponseResult(CommonCode.DATA_IS_NULL);
    }

    /**
     * 拦截捕捉异常 ClassCastException.class
     *
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = ClassCastException.class)
    public ResponseResult ClassCastExceptionErrorHandler(ClassCastException e) {
        log.info("类型转换错误:{}", e.getMessage());
        return new ResponseResult(CommonCode.INVALID_CAST);
    }

    /**
     * 拦截捕捉异常 IOException.class
     *
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = IOException.class)
    public ResponseResult IOExceptionErrorHandler(IOException e) {
        log.info("文件导入或导出失败:{}", e.getMessage());
        return new ResponseResult(CommonCode.INVALID_FILE_IO);
    }

    /**
     * 拦截捕捉异常 IllegalArgumentException.class
     *
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseResult IllegalArgumentExceptionHandler(IllegalArgumentException e) {
        log.info("非法参数: {}", e.getMessage());
        return new ResponseResult(CommonCode.INVALID_PARAM);
    }

    /**
     * 拦截捕捉异常 InvalidDataAccessApiUsageException.class
     *
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = InvalidDataAccessApiUsageException.class)
    public ResponseResult InvalidDataAccessApiUsageExceptionHandler(InvalidDataAccessApiUsageException e) {
        log.info("InvalidDataAccessApiUsageExceptionHandler  数据查询异常");
        return new ResponseResult(CommonCode.DATA_IS_WRONG);
    }

    //定义map，配置异常类型所对应的错误代码
    private static ImmutableMap<Class<? extends Throwable>, ResultCode> EXCEPTIONS;
    //定义map的builder对象，去构建ImmutableMap
    protected static ImmutableMap.Builder<Class<? extends Throwable>, ResultCode> builder = ImmutableMap.builder();

    //捕获CustomException此类异常
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResponseResult customException(CustomException customException) {
        //记录日志
        ResultCode resultCode = customException.getResultCode();
        log.error("catch customException: {}", resultCode.message());
        return new ResponseResult(resultCode);
    }

    //捕获Exception此类异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult exception(Exception exception) {
        //记录日志
        log.error("catch exception:{}", exception.getMessage());
        if (EXCEPTIONS == null) {
            EXCEPTIONS = builder.build();//EXCEPTIONS构建成功
        }
        //从EXCEPTIONS中找异常类型所对应的错误代码，如果找到了将错误代码响应给用户，如果找不到给用户响应99999异常
        ResultCode resultCode = EXCEPTIONS.get(exception.getClass());
        if (resultCode != null) {
            return new ResponseResult(resultCode);
        } else {
            //返回99999异常
            return new ResponseResult(CommonCode.SERVER_ERROR);
        }

    }

    static {
        //定义异常类型所对应的错误代码
        builder.put(HttpMessageNotReadableException.class, CommonCode.INVALID_PARAM);
    }
}
