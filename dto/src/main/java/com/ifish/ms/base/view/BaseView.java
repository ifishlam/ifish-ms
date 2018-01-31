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

package com.ifish.ms.base.view;

import com.ifish.ms.base.bean.BaseBean;
import com.ifish.ms.core.util.DateTimeUtils;
import com.ifish.ms.core.util.SystemConstants;
import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Table;

public class BaseView<Bean extends BaseBean> implements Serializable {

    private static final long serialVersionUID = 1L;

    protected final Bean detailBean;

    protected final String tableName;


    protected BaseView(Bean detailBean) {
        this.detailBean = detailBean;
        this.tableName = detailBean.getClass().getAnnotation(Table.class).name();
    }

    protected String formatTimestamp(Timestamp ts) {

        return DateTimeUtils.formatTimestamp(ts);
    }

    protected String formatBoolean(String s) {

        if (SystemConstants.DB_RECORD_STRING_TRUE.getValue().equalsIgnoreCase(s)) {
            return "有效";
        }
        return "无效";
    }
}