package com.stx.pro.utils;

/**
 * @author RenBoQing
 * @date 2022年06月02日 10:28
 * @Description
 */
public enum ResultCode  implements  IErrorCode{
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已过期"),
    FORBIDDEN(403, "没有相关权限");

    /** 定义状态码 */
    private long code;

    /** 定义返回信息 */
    private String message;

    ResultCode() {
    }

    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
