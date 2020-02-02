package com.wing.exception;

/**
 * @author heweiye
 * @version 1.0
 * @description 错误类型
 * @date 2020/1/17 17:14
 */
public interface ErrorType {

    /**
     * 返回错误码
     * @return
     */
    String getCode();


    /**
     * 返回错误描述信息
     * @return
     */
    String getMsg();
}
