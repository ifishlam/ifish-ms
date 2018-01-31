/*
 * Copyright (c) 2017. iFish Studio.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 * @author Angus Lam
 * @date 2017/10/21
 *
 *
 */

package com.ifish.ms.core.util;

public enum SystemConstants {

    DB_RECORD_STRING_TRUE("+"),
    DB_RECORD_STRING_FALSE("-"),
    STRING_BLANK(""),
    RECORD_SEPARATOR("#"),

    FORMATTER_DATE_YYYYMMDD("yyyy-MM-dd"),
    FORMATTER_DATE_MMDD("MM-dd"),
    FORMATTER_DATE_TIME_FULL("yyyy-MM-dd HH:mm:ss"),
    FORMATTER_DATE_TIME_IN_NUMBER("yyyyMMddHHmmss"),;

    private String value;

    SystemConstants(String value) {
        this.value = value;
    }

    public String getValue() {

        return value;
    }

    public void setValue(String value) {

        this.value = value;
    }
}
