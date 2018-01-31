/*
 * Copyright (c) 2017. iFish Studio.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 * @author Angus Lam
 * @date 2017/10/20
 *
 *
 */

package com.ifish.ms.base.web;

public enum ResponseResultCode {

    /**
     * 请求成功
     */
    SUCCESS("200", "成功"),

    /**
     * 系统内部错误
     */
    ERROR_SYSTEM("402", "系统错误"),

    /**
     * 传入参数错误
     */
    ERROR_PARAMS("403", "参数错误 ");

    private String code;

    private String message;

    ResponseResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
