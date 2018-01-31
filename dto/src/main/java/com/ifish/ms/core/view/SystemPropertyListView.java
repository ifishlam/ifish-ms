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
import com.ifish.ms.core.bean.SystemPropertyBean;

public class SystemPropertyListView extends BaseListView<SystemPropertyBean> {

    private static final long serialVersionUID = 1L;

    public SystemPropertyListView(Iterable beanList, Class viewClass) {
        super(beanList, viewClass);
    }

    public SystemPropertyListView(Iterable beanList) {
        super(beanList, SystemPropertyBasicView.class);
    }
}

