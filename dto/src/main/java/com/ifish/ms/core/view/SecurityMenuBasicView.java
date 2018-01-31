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

package com.ifish.ms.core.view;

import com.ifish.ms.base.view.BaseView;
import com.ifish.ms.core.bean.SecurityMenuBean;

public class SecurityMenuBasicView extends BaseView<SecurityMenuBean> {

    private static final long serialVersionUID = 1L;

    public SecurityMenuBasicView(SecurityMenuBean detailBean) {
        super(detailBean);
    }

    public int getId() {
        return this.detailBean.getId();
    }

    public String getActive() {
        return this.detailBean.getActive();
    }

    public String getIntlId() {
        return this.detailBean.getIntlId();
    }

    public String getName() {
        return this.detailBean.getName();
    }

    public String getHref() {
        return this.detailBean.getHref();
    }

    public int getPositionX() {
        return this.detailBean.getPositionX();
    }

    public int getPositionY() {
        return this.detailBean.getPositionY();
    }

    public String getRemark() {
        return this.detailBean.getRemark();
    }

}
