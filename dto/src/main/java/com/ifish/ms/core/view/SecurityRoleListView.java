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

import com.ifish.ms.base.view.BaseListView;
import com.ifish.ms.core.bean.SecurityRoleBean;

public class SecurityRoleListView extends BaseListView<SecurityRoleBean> {

    private static final long serialVersionUID = 1L;

    public SecurityRoleListView(Iterable beanList, Class viewClass) {
        super(beanList, viewClass);
    }

    public SecurityRoleListView(Iterable beanList) {
        super(beanList, SecurityRoleBasicView.class);
    }
}

