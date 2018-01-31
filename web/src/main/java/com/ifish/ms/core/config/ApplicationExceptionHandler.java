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

package com.ifish.ms.core.config;

import com.google.common.base.Strings;
import com.ifish.ms.base.web.ResponseResult;
import com.ifish.ms.core.exception.ApplicationException;
import com.ifish.ms.core.exception.ApplicationExceptionCode;
import com.ifish.ms.core.util.DateTimeUtils;
import com.ifish.ms.core.util.SystemConstants;
import java.util.concurrent.atomic.AtomicLong;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(ApplicationExceptionHandler.class);

    private final AtomicLong errorId = new AtomicLong();

    @ExceptionHandler(Exception.class)
    public ResponseResult handleError(Exception e) {

        String exceptionId = createExceptionId();

        String errorCode = null;
        String errorMsg = null;

        if (e instanceof ApplicationException) {
            String[] msg = e.getMessage().split(SystemConstants.RECORD_SEPARATOR.getValue());
            if (msg.length > 1) {
                errorCode = msg[0];
                errorMsg = msg[1];
            }
        } else if (e instanceof DataAccessException) {
            errorCode = ApplicationExceptionCode.ERROR_CORE_DB_DATA_ACCESS.getCode();
            errorMsg = ApplicationExceptionCode.ERROR_CORE_DB_DATA_ACCESS.getMessage();
        } else if (e instanceof IllegalStateException) {
            errorCode = ApplicationExceptionCode.ERROR_SYSTEM_INVALID_PARAMS.getCode();
            errorMsg = ApplicationExceptionCode.ERROR_SYSTEM_INVALID_PARAMS.getMessage();
        } else if (e instanceof NullPointerException) {
            errorCode = ApplicationExceptionCode.ERROR_CORE_INVALID_PARAMS.getCode();
            errorMsg = ApplicationExceptionCode.ERROR_CORE_INVALID_PARAMS.getMessage() + e.getMessage();
        }

        if (Strings.isNullOrEmpty(errorCode)) {
            errorCode = ApplicationExceptionCode.ERROR_SYSTEM_UNKNOWN.getCode();
            errorMsg = ApplicationExceptionCode.ERROR_SYSTEM_UNKNOWN.getMessage();
        }

        logger.error("Exception ID: " + exceptionId, e);
        return new ResponseResult(errorCode, errorMsg + " (错误ID:" + exceptionId + ")");
    }

    private String createExceptionId() {

        return DateTimeUtils.formatTimestamp2Number(DateTimeUtils.getCurrentTime()) + "-" + String.valueOf(errorId.incrementAndGet());
    }

}
