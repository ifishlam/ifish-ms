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
import com.ifish.ms.core.bean.SecurityUserBean;

public class SecurityUserBasicView extends BaseView<SecurityUserBean> {

    private static final long serialVersionUID = 1L;

    public SecurityUserBasicView(SecurityUserBean detailBean) {
        super(detailBean);
    }

    public String getId() {
        return String.valueOf(this.detailBean.getId());
    }

    public String getActive() {
        return this.detailBean.getActive();
    }

    public String getUserId() {
        return this.detailBean.getUserId();
    }

    public String getUserName() {
        return this.detailBean.getUserName();
    }

    public String getEnabled() {
        return this.detailBean.getEnabled();
    }

    public String getLocked() {
        return this.detailBean.getLocked();
    }

    public String getExpired() {
        return this.detailBean.getExpired();
    }

    public String getFailTimes() {
        return String.valueOf(this.detailBean.getFailTimes());
    }

    public String getCreateUserId() {
        return String.valueOf(this.detailBean.getCreateUserId());
    }

    public String getCreateTs() {
        return formatTimestamp(this.detailBean.getCreateTs());
    }

    public String getUpdateUserId() {
        return String.valueOf(this.detailBean.getUpdateUserId());
    }

    public String getUpdateTs() {
        return formatTimestamp(this.detailBean.getUpdateTs());
    }

    public String getRemark() {
        return this.detailBean.getRemark();
    }


}
