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
import com.ifish.ms.core.bean.SecurityUserRoleBean;


public class SecurityUserRoleBasicView extends BaseView<SecurityUserRoleBean> {

    private static final long serialVersionUID = 1L;

    public SecurityUserRoleBasicView(SecurityUserRoleBean detailBean) {
        super(detailBean);
    }

    public String getActive() {
        return this.detailBean.getActive();
    }

    public int getSecurityUserId() {
        return this.detailBean.getSecurityUserRolePrimaryKey().getSecurityUser().getId();
    }

    public int getSecurityRoleId() {

        return this.detailBean.getSecurityUserRolePrimaryKey().getSecurityRole().getId();
    }

    public String getRemark() {
        return this.detailBean.getRemark();
    }


}
