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
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "security_menu_role")
public class SecurityMenuRoleBean extends BaseBean {

    @Column(name = "active")
    private String active;

    @EmbeddedId
    private SecurityMenuRolePrimaryKey securityMenuRolePrimaryKey;

    @Column(name = "remark")
    private String remark;

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public SecurityMenuRolePrimaryKey getSecurityMenuRolePrimaryKey() {
        return securityMenuRolePrimaryKey;
    }

    public void setSecurityMenuRolePrimaryKey(SecurityMenuRolePrimaryKey securityMenuRolePrimaryKey) {
        this.securityMenuRolePrimaryKey = securityMenuRolePrimaryKey;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
