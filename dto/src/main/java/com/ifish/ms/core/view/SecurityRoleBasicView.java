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
import com.ifish.ms.core.bean.SecurityRoleBean;


public class SecurityRoleBasicView extends BaseView<SecurityRoleBean> {

    private static final long serialVersionUID = 1L;

    public SecurityRoleBasicView(SecurityRoleBean detailBean) {
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

    public String getRemark() {
        return this.detailBean.getRemark();
    }


}
