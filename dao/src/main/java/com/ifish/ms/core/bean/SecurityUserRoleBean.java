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
@Table(name = "security_user_role")
public class SecurityUserRoleBean extends BaseBean {

    @Column(name = "active")
    private String active;

    @EmbeddedId
    private SecurityUserRolePrimaryKey securityUserRolePrimaryKey;

    @Column(name = "remark")
    private String remark;

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public SecurityUserRolePrimaryKey getSecurityUserRolePrimaryKey() {
        return securityUserRolePrimaryKey;
    }

    public void setSecurityUserRolePrimaryKey(SecurityUserRolePrimaryKey securityUserRolePrimaryKey) {
        this.securityUserRolePrimaryKey = securityUserRolePrimaryKey;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
