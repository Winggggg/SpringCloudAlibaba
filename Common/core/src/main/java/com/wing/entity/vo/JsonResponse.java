package com.wing.entity.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.wing.exception.BaseException;
import com.wing.exception.ErrorType;
import com.wing.exception.SystemErrorType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import java.time.Instant;
import java.time.ZonedDateTime;

/**
 * @author heweiye
 * @version 1.0
 * @description rest请求的返回模型，所有rest正常都返回该类的对象
 * @date 2020/1/17 17:04
 */
@ApiModel(description = "rest请求的返回模型，所有rest正常都返回该类的对象")
@Getter
public class JsonResponse<T> {

    @ApiModelProperty(value = "处理结果code", required = true)
    private String code;
    @ApiModelProperty(value = "处理结果描述信息")
    private String msg;
    @ApiModelProperty(value = "请求结果生成时间戳")
    private Instant time;
    @ApiModelProperty(value = "处理结果数据信息")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public JsonResponse() {
        this.time = ZonedDateTime.now().toInstant();
    }

    /**
     * @param errorType
     */
    public JsonResponse(ErrorType errorType) {
        this.code = errorType.getCode();
        this.msg = errorType.getMsg();
        this.time = ZonedDateTime.now().toInstant();
    }

    /**
     * @param errorType
     * @param data
     */
    public JsonResponse(ErrorType errorType, T data) {
        this(errorType);
        this.data = data;
    }

    /**
     * 内部使用，用于构造成功的结果
     *
     * @param code
     * @param msg
     * @param data
     */
    private JsonResponse(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.time = ZonedDateTime.now().toInstant();
    }

    /**
     * 快速创建成功结果并返回结果数据
     *
     * @param data
     * @return JsonResponse
     */
    public static JsonResponse success(Object data) {
        return new JsonResponse<>(SystemErrorType.SYSTEM_SUCCESS, data);
    }

    /**
     * 快速创建成功结果
     *
     * @return JsonResponse
     */
    public static JsonResponse success() {
        return success(null);
    }

    /**
     * 系统异常类没有返回数据
     *
     * @return JsonResponse
     */
    public static JsonResponse fail() {
        return new JsonResponse(SystemErrorType.SYSTEM_ERROR);
    }

    /**
     * 系统异常类没有返回数据
     *
     * @param baseException
     * @return JsonResponse
     */
    public static JsonResponse fail(BaseException baseException) {
        return fail(baseException, null);
    }

    /**
     * 系统异常类并返回结果数据
     *
     * @param data
     * @return JsonResponse
     */
    public static JsonResponse fail(BaseException baseException, Object data) {
        return new JsonResponse<>(baseException.getErrorType(), data);
    }

    /**
     * 系统异常类并返回结果数据
     *
     * @param errorType
     * @param data
     * @return JsonResponse
     */
    public static JsonResponse fail(ErrorType errorType, Object data) {
        return new JsonResponse<>(errorType, data);
    }

    /**
     * 系统异常类并返回结果数据
     *
     * @param errorType
     * @return JsonResponse
     */
    public static JsonResponse fail(ErrorType errorType) {
        return JsonResponse.fail(errorType, null);
    }

    /**
     * 系统异常类并返回结果数据
     *
     * @param data
     * @return JsonResponse
     */
    public static JsonResponse fail(Object data) {
        return new JsonResponse<>(SystemErrorType.SYSTEM_ERROR, data);
    }


    /**
     * 成功code=000000
     *
     * @return true/false
     */
    @JsonIgnore
    public boolean isSuccess() {
        return SystemErrorType.SYSTEM_SUCCESS.getCode().equals(this.code);
    }

    /**
     * 失败
     *
     * @return true/false
     */
    @JsonIgnore
    public boolean isFail() {
        return !isSuccess();
    }

}
