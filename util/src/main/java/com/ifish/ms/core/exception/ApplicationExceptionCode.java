package com.ifish.ms.core.exception;

public enum ApplicationExceptionCode {

    // System level error
    ERROR_SYSTEM_UNKNOWN("51001", "系统未知错误"),
    ERROR_SYSTEM_INVALID_PARAMS("51002", "请求的参数缺失或错误"),

    // Application core level error
    ERROR_CORE_UNKNOWN("52001", "系统核心程序发生未知错误."),
    ERROR_CORE_INVALID_PARAMS("52002", "系统核心程序参数错误."),
    ERROR_CORE_DB_DATA_ACCESS("52003", "系统核心程序发生数据库错误."),

    // Application core level exception
    EXCEPTION_CORE_DATA_NOT_FOUND("52001", "系统找不到指定数据."),
    EXCEPTION_CORE_DATA_ALREADY_EXIST("52002", "系统已存在相同数据."),
    EXCEPTION_CORE_USER_PASSWORD_NOT_MATCH("52003", "用户密码不匹配."),;

    private String code;

    private String message;

    ApplicationExceptionCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
