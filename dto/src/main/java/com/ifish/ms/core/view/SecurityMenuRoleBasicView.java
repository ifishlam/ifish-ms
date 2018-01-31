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
import com.ifish.ms.core.bean.SecurityMenuRoleBean;


public class SecurityMenuRoleBasicView extends BaseView<SecurityMenuRoleBean> {

    private static final long serialVersionUID = 1L;

    public SecurityMenuRoleBasicView(SecurityMenuRoleBean detailBean) {
        super(detailBean);
    }

    public String getActive() {
        return this.detailBean.getActive();
    }

    public int getSecurityMenuId() {
        return this.detailBean.getSecurityMenuRolePrimaryKey().getSecurityMenuId();
    }

    public int getSecurityRoleId() {
        return this.detailBean.getSecurityMenuRolePrimaryKey().getSecurityRoleId();
    }

    public String getRemark() {
        return this.detailBean.getRemark();
    }


}
