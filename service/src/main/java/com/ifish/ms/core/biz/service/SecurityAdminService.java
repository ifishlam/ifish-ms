/*
 * Copyright (c) 2017. iFish Studio.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 * @author Angus Lam
 * @date 2017/11/24
 *
 *
 */

package com.ifish.ms.core.biz.service;

import com.ifish.ms.core.exception.ApplicationException;
import com.ifish.ms.core.view.RespondSecurityAdminView;
import com.ifish.ms.core.view.SecurityMenuBasicView;
import com.ifish.ms.core.view.SecurityMenuListView;
import com.ifish.ms.core.view.SecurityRoleBasicView;
import com.ifish.ms.core.view.SecurityRoleListView;

public interface SecurityAdminService {

    /**
     * Get all the users with basic information
     *
     * @return RespondSecurityAdminView
     * @throws ApplicationException if have error
     */
    RespondSecurityAdminView listUsers() throws ApplicationException;

    /**
     * Get all active users with basic information
     *
     * @return RespondSecurityAdminView
     * @throws ApplicationException if have error
     */
    RespondSecurityAdminView listActiveUsers() throws ApplicationException;

    /**
     * Get user basic information by user numeric id
     *
     * @param userNumericId
     * @return RespondSecurityAdminView
     * @throws ApplicationException if have error
     */
    RespondSecurityAdminView getUserById(Integer userNumericId) throws ApplicationException;

    /**
     * @param userNumericId
     * @param password
     * @return
     * @throws ApplicationException if have error
     */
    RespondSecurityAdminView processLogin(Integer userNumericId, String password) throws ApplicationException;

    /**
     * Create a new user
     *
     * @param userId
     * @param userName
     * @param password
     * @param remark
     * @param createUserId
     * @return RespondSecurityAdminView
     * @throws ApplicationException if have error
     */
    RespondSecurityAdminView createUser(String userId, String userName, String password, String remark, Integer createUserId) throws ApplicationException;

    /**
     * Enable/Disable user
     *
     * @param updateUserId
     * @param userNumericId
     * @param isEnable
     * @param remark
     * @return
     * @throws ApplicationException if have error
     */
    RespondSecurityAdminView updateUserEnableFlag(Integer updateUserId, Integer userNumericId, boolean isEnable, String remark) throws ApplicationException;

    /**
     * Lock/Un-Lock user
     *
     * @param updateUserId
     * @param userNumericId
     * @param isLock
     * @param remark
     * @return
     * @throws ApplicationException if have error
     */
    RespondSecurityAdminView updateUserLockFlag(Integer updateUserId, Integer userNumericId, boolean isLock, String remark) throws ApplicationException;

    /**
     * Expire/Dis-Expire the user
     *
     * @param updateUserId
     * @param userNumericId
     * @param isExpire
     * @param remark
     * @return
     * @throws ApplicationException if have error
     */
    RespondSecurityAdminView updateUserExpireFlag(Integer updateUserId, Integer userNumericId, boolean isExpire, String remark) throws ApplicationException;

    /**
     * Active/In-Active user
     *
     * @param updateUserId
     * @param userNumericId
     * @param isActive
     * @param remark
     * @return
     * @throws ApplicationException if have error
     */
    RespondSecurityAdminView updateUserActiveFlag(Integer updateUserId, Integer userNumericId, boolean isActive, String remark) throws ApplicationException;

    /**
     * Set user login fail times
     *
     * @param updateUserId
     * @param userNumericId
     * @param failTimes
     * @param remark
     * @return
     * @throws ApplicationException if have error
     */
    RespondSecurityAdminView updateUserLoginFailTimes(Integer updateUserId, Integer userNumericId, Integer failTimes, String remark) throws ApplicationException;

    /**
     * Set user name
     *
     * @param updateUserId
     * @param userNumericId
     * @param userName
     * @param remark
     * @return
     * @throws ApplicationException if have error
     */
    RespondSecurityAdminView updateUserName(Integer updateUserId, Integer userNumericId, String userName, String remark) throws ApplicationException;

    /**
     * Set user password
     *
     * @param updateUserId
     * @param userNumericId
     * @param password
     * @param remark
     * @return
     * @throws ApplicationException if have error
     */
    RespondSecurityAdminView updateUserPassword(Integer updateUserId, Integer userNumericId, String password, String remark) throws ApplicationException;

    /**
     * Get roles by user numeric id
     *
     * @param userNumericId
     * @return SecurityRoleListView
     * @throws ApplicationException if have error
     */
    SecurityRoleListView listRolesByUserId(Integer userNumericId) throws ApplicationException;

    /**
     * Save user role
     *
     * @param userNumericId
     * @param roleNumericId
     * @param remark
     * @return SecurityRoleBasicView
     * @throws ApplicationException if have error
     */
    SecurityRoleBasicView saveUserRole(Integer userNumericId, Integer roleNumericId, String remark) throws ApplicationException;

    /**
     * Get all the roles with basic information
     *
     * @return SecurityRoleListView
     * @throws ApplicationException if have error
     */
    SecurityRoleListView listRoles() throws ApplicationException;

    /**
     * Get role basic information by role numeric id
     *
     * @param roleNumericId
     * @return SecurityRoleBasicView
     * @throws ApplicationException if have error
     */
    SecurityRoleBasicView getRoleById(Integer roleNumericId) throws ApplicationException;


    /**
     * Create role
     *
     * @param active
     * @param intlId
     * @param name
     * @param remark
     * @return
     * @throws ApplicationException if have error
     */
    SecurityRoleBasicView createRole(String active, String intlId, String name, String remark) throws ApplicationException;

    /**
     * Update role
     *
     * @param roleNumericId
     * @param active
     * @param name
     * @param remark
     * @return
     * @throws ApplicationException if have error
     */
    SecurityRoleBasicView updateRole(Integer roleNumericId, String active, String name, String remark) throws ApplicationException;


    /**
     * Get all the menus with basic information
     */
    SecurityMenuListView listMenus() throws ApplicationException;

    /**
     * Get menu basic information by menu numeric id
     */
    SecurityMenuBasicView getMenuById(Integer menuNumericId) throws ApplicationException;

}
