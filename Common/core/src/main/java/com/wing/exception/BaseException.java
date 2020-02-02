package com.wing.exception;

import lombok.Getter;

/**
 * @author heweiye
 * @version 1.0
 * @description 异常基础类
 * @date 2020/1/17 17:27
 */
@Getter
public class BaseException extends RuntimeException {

    private ErrorType errorType;

    /**
     * 默认系统异常
     */
    public BaseException() {
        this.errorType=SystemErrorType.SYSTEM_ERROR;
    }

    public BaseException(ErrorType errorType) {
        this.errorType = errorType;
    }

    public BaseException(String message, ErrorType errorType) {
        super(message);
        this.errorType = errorType;
    }

    public BaseException(String message, Throwable cause, ErrorType errorType) {
        super(message, cause);
        this.errorType = errorType;
    }
}
