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

package com.ifish.ms.core.bean;

import com.ifish.ms.base.bean.BaseBean;
import javax.persistence.Embeddable;

@Embeddable
public class SecurityMenuRolePrimaryKey extends BaseBean {

    private Integer securityMenuId;

    private Integer securityRoleId;

    public SecurityMenuRolePrimaryKey() {
    }

    public SecurityMenuRolePrimaryKey(Integer securityMenuId, Integer securityRoleId) {
        this.securityMenuId = securityMenuId;
        this.securityRoleId = securityRoleId;
    }

    public Integer getSecurityMenuId() {
        return securityMenuId;
    }

    public void setSecurityMenuId(Integer securityMenuId) {
        this.securityMenuId = securityMenuId;
    }

    public Integer getSecurityRoleId() {
        return securityRoleId;
    }

    public void setSecurityRoleId(Integer securityRoleId) {
        this.securityRoleId = securityRoleId;
    }
}
