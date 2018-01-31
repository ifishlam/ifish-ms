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


import java.sql.Date;
import java.sql.Timestamp;
import org.apache.commons.lang3.time.DateFormatUtils;

public class DateTimeUtils {

    public static Timestamp getCurrentTime() {

        return new Timestamp(System.currentTimeMillis());
    }

    public static String format2LongDate(Timestamp ts) {

        return formatTimestamp(ts, SystemConstants.FORMATTER_DATE_YYYYMMDD.getValue());
    }

    public static String format2LongDate(Date date) {

        return DateFormatUtils.format(date, SystemConstants.FORMATTER_DATE_YYYYMMDD.getValue());
    }

    public static String format2ShortDate(Timestamp ts) {

        return formatTimestamp(ts, SystemConstants.FORMATTER_DATE_MMDD.getValue());
    }

    public static String format2ShortDate(Date date) {

        return formatDate(date, SystemConstants.FORMATTER_DATE_MMDD.getValue());
    }

    public static String formatTimestamp(Timestamp ts) {

        return formatTimestamp(ts, SystemConstants.FORMATTER_DATE_TIME_FULL.getValue());
    }

    public static String formatTimestamp2Number(Timestamp ts) {

        return formatTimestamp(ts, SystemConstants.FORMATTER_DATE_TIME_IN_NUMBER.getValue());
    }

    private static String formatDate(Date date, String format) {
        if (date != null) {
            return DateFormatUtils.format(date, format);
        } else {
            return SystemConstants.STRING_BLANK.getValue();
        }
    }

    private static String formatTimestamp(Timestamp ts, String format) {
        if (ts != null) {
            return DateFormatUtils.format(ts.getTime(), format);
        } else {
            return SystemConstants.STRING_BLANK.getValue();
        }
    }

}
