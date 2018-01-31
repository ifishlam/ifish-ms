/*
 * Copyright (c) 2017. iFish Studio.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 * @author Angus Lam
 * @date 2017/11/5
 *
 *
 */

package com.ifish.ms.core.service.impl;

import com.ifish.ms.core.bean.SecurityRoleBean;
import com.ifish.ms.core.dao.SecurityRoleDAO;
import com.ifish.ms.core.exception.ApplicationException;
import com.ifish.ms.core.service.SecurityRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("securityRoleService")
public class SecurityRoleServiceImpl implements SecurityRoleService {

    @Autowired
    public SecurityRoleDAO securityRoleDAO;

    @Override
    public Iterable<SecurityRoleBean> listRoles() throws ApplicationException {

        return securityRoleDAO.findAll();
    }

    @Override
    public SecurityRoleBean getRoleById(Integer roleNumericId, boolean isActiveOnly) throws ApplicationException {
        return null;
    }

    @Override
    public SecurityRoleBean getRoleByIntlId(String intlId, boolean isActiveOnly) throws ApplicationException {
        return null;
    }

    @Override
    public SecurityRoleBean createRole(String intlId, String name, String remark) throws ApplicationException {
        return null;
    }

    @Override
    public SecurityRoleBean updateRole(SecurityRoleBean role) throws ApplicationException {
        return null;
    }
}
