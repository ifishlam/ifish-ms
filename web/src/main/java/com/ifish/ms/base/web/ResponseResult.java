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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class ResponseResult {

    private String code;

    private String message;

    private String errorCode;

    private String errorMessage;

    private Object data;

    /**
     * Constructor for SUCCESS result without data information
     */
    public ResponseResult() {
        this.setCode(ResponseResultCode.SUCCESS);
        this.setMessage(ResponseResultCode.SUCCESS);
    }

    /**
     * Constructor for SUCCESS result with data information
     */
    public ResponseResult(Object data) {
        this.setCode(ResponseResultCode.SUCCESS);
        this.setMessage(ResponseResultCode.SUCCESS);
        this.setData(data);
    }

    /**
     * Constructor for ERROR result
     */
    public ResponseResult(String errorCode, String errorMessage) {

        this.setCode(ResponseResultCode.ERROR_SYSTEM);
        this.setMessage(ResponseResultCode.ERROR_SYSTEM);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getCode() {

        return code;
    }

    public void setCode(ResponseResultCode resultCode) {
        this.code = resultCode.getCode();
    }

    public String getMessage() {

        return message;
    }

    public void setMessage(ResponseResultCode resultCode) {
        this.message = resultCode.getMessage();
    }

    public String getErrorCode() {

        return errorCode;
    }

    public String getErrorMessage() {

        return errorMessage;
    }

    public Object getData() {

        return data;
    }

    public void setData(Object data) {

        this.data = data;
    }

}
