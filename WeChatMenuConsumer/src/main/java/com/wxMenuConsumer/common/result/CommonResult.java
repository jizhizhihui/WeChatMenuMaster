package com.wxMenuConsumer.common.result;

import com.wxMenuAPI.common.result.IErrorCode;
import com.wxMenuAPI.common.result.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * 统一结果返回类
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CommonResult<T> implements Serializable {
    private int code;
    private String message;
    private T data;

    /**
     * 成功
     *
     * @param data 传入数据
     */
    public static <T> com.wxMenuAPI.common.result.CommonResult<T> success(T data) {
        return new com.wxMenuAPI.common.result.CommonResult<>(com.wxMenuAPI.common.result.ResultCode.SUCCESS.getCode(), com.wxMenuAPI.common.result.ResultCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功
     * 自定义提示信息
     *
     * @param data    传入数据
     * @param message 提示信息
     */
    public static <T> com.wxMenuAPI.common.result.CommonResult<T> success(T data, String message) {
        return new com.wxMenuAPI.common.result.CommonResult<>(com.wxMenuAPI.common.result.ResultCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败
     * 自定义错误
     *
     * @param errorCode 错误
     */
    public static <T> com.wxMenuAPI.common.result.CommonResult<T> failed(IErrorCode errorCode) {
        return new com.wxMenuAPI.common.result.CommonResult<>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败
     */
    public static <T> com.wxMenuAPI.common.result.CommonResult<T> failed() {
        return failed(com.wxMenuAPI.common.result.ResultCode.FAILED);
    }

    /**
     * 失败
     * 自定义提示信息
     */
    public static <T> com.wxMenuAPI.common.result.CommonResult<T> failed(String message) {
        return new com.wxMenuAPI.common.result.CommonResult<>(com.wxMenuAPI.common.result.ResultCode.FAILED.getCode(), message, null);
    }

    /**
     * 参数验证失败 500
     */
    public static <T> com.wxMenuAPI.common.result.CommonResult<T> validateFailed() {
        return failed(com.wxMenuAPI.common.result.ResultCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败 300
     * 自定义提示信息
     */
    public static <T> com.wxMenuAPI.common.result.CommonResult<T> validateFailed(String message) {
        return new com.wxMenuAPI.common.result.CommonResult<>(com.wxMenuAPI.common.result.ResultCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录401
     */
    public static <T> com.wxMenuAPI.common.result.CommonResult<T> unauthorized(T data) {
        return new com.wxMenuAPI.common.result.CommonResult<>(com.wxMenuAPI.common.result.ResultCode.UNAUTHORIZED.getCode(), com.wxMenuAPI.common.result.ResultCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权403
     */
    public static <T> com.wxMenuAPI.common.result.CommonResult<T> forbidden(T data) {
        return new com.wxMenuAPI.common.result.CommonResult<>(com.wxMenuAPI.common.result.ResultCode.FORBIDDEN.getCode(), com.wxMenuAPI.common.result.ResultCode.FORBIDDEN.getMessage(), data);
    }

    /**
     * 警告301
     */
    public static <T> com.wxMenuAPI.common.result.CommonResult<T> warn(String message) {
        return new com.wxMenuAPI.common.result.CommonResult<>(ResultCode.WARN.getCode(), message, null);
    }
}
