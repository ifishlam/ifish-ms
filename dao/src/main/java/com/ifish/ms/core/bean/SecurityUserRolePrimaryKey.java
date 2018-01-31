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
import javax.persistence.ManyToOne;

@Embeddable
public class SecurityUserRolePrimaryKey extends BaseBean {

    @ManyToOne
    public SecurityUserBean securityUser;

    @ManyToOne
    public SecurityRoleBean securityRole;

    public SecurityUserRolePrimaryKey() {
    }

    public SecurityUserRolePrimaryKey(SecurityUserBean securityUser, SecurityRoleBean securityRole) {
        this.securityUser = securityUser;
        this.securityRole = securityRole;
    }

    public SecurityUserBean getSecurityUser() {
        return securityUser;
    }

    public void setSecurityUser(SecurityUserBean securityUser) {
        this.securityUser = securityUser;
    }

    public SecurityRoleBean getSecurityRole() {
        return securityRole;
    }

    public void setSecurityRole(SecurityRoleBean securityRole) {
        this.securityRole = securityRole;
    }

}
