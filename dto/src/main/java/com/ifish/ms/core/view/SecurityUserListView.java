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
import com.ifish.ms.core.bean.SecurityUserBean;

public class SecurityUserListView extends BaseListView<SecurityUserBean> {

    private static final long serialVersionUID = 1L;

    public SecurityUserListView(Iterable beanList, Class viewClass) {
        super(beanList, viewClass);
    }

    public SecurityUserListView(Iterable beanList) {
        super(beanList, SecurityUserBasicView.class);
    }
}
