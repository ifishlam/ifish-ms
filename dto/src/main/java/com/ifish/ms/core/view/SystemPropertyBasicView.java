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
import com.ifish.ms.core.bean.SystemPropertyBean;


public class SystemPropertyBasicView extends BaseView<SystemPropertyBean> {

    private static final long serialVersionUID = 1L;

    public SystemPropertyBasicView(SystemPropertyBean detailBean) {
        super(detailBean);
    }

    public String getActive() {
        return this.detailBean.getActive();
    }

    public String getKey() {
        return this.detailBean.getKey();
    }

    public String getValue() {
        return this.detailBean.getValue();
    }

    public String getRemark() {
        return this.detailBean.getRemark();
    }


}
