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

package com.ifish.ms.core.service;

import com.ifish.ms.core.bean.SecurityRoleBean;
import com.ifish.ms.core.exception.ApplicationException;

public interface SecurityRoleService {

    /**
     * Get all the roles with basic information
     *
     * @return Iterable<SecurityRoleBean>
     * @throws ApplicationException if have error
     */
    Iterable<SecurityRoleBean> listRoles() throws ApplicationException;

    /**
     * Get role by role numeric id
     *
     * @param roleNumericId
     * @param isActiveOnly
     * @return SecurityRoleBean
     * @throws ApplicationException
     */
    SecurityRoleBean getRoleById(Integer roleNumericId, boolean isActiveOnly) throws ApplicationException;

    /**
     * Get role by role internal id
     *
     * @param intlId
     * @param isActiveOnly
     * @return SecurityRoleBean
     * @throws ApplicationException if have error
     */
    SecurityRoleBean getRoleByIntlId(String intlId, boolean isActiveOnly) throws ApplicationException;

    /**
     * Create a new role
     *
     * @param intlId
     * @param name
     * @param remark
     * @return SecurityRoleBean
     * @throws ApplicationException if have error
     */
    SecurityRoleBean createRole(String intlId, String name, String remark) throws ApplicationException;

    /**
     * Update a role
     *
     * @param role
     * @return SecurityRoleBean
     * @throws ApplicationException if have error
     */
    SecurityRoleBean updateRole(SecurityRoleBean role) throws ApplicationException;

}
