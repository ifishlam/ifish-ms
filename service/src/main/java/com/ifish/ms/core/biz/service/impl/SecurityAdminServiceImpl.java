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

package com.ifish.ms.core.biz.service.impl;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.ifish.ms.core.bean.SecurityMenuBean;
import com.ifish.ms.core.bean.SecurityRoleBean;
import com.ifish.ms.core.bean.SecurityUserBean;
import com.ifish.ms.core.bean.SecurityUserRoleBean;
import com.ifish.ms.core.bean.SecurityUserRolePrimaryKey;
import com.ifish.ms.core.dao.SecurityMenuDAO;
import com.ifish.ms.core.dao.SecurityMenuRoleDAO;
import com.ifish.ms.core.dao.SecurityRoleDAO;
import com.ifish.ms.core.dao.SecurityUserRoleDAO;
import com.ifish.ms.core.exception.ApplicationException;
import com.ifish.ms.core.exception.ApplicationExceptionCode;
import com.ifish.ms.core.biz.service.EncryptService;
import com.ifish.ms.core.biz.service.SecurityAdminService;
import com.ifish.ms.core.service.SecurityUserService;
import com.ifish.ms.core.util.DateTimeUtils;
import com.ifish.ms.core.util.ObjectUtils;
import com.ifish.ms.core.util.SystemConstants;
import com.ifish.ms.core.view.RespondSecurityAdminView;
import com.ifish.ms.core.view.SecurityMenuBasicView;
import com.ifish.ms.core.view.SecurityMenuListView;
import com.ifish.ms.core.view.SecurityRoleBasicView;
import com.ifish.ms.core.view.SecurityRoleListView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("securityAdminService")
public class SecurityAdminServiceImpl implements SecurityAdminService {

    private static final String USER_FLAG_ACTIVE = "AT";
    private static final String USER_FLAG_ENABLE = "EA";
    private static final String USER_FLAG_LOCK = "LK";
    private static final String USER_FLAG_EXPIRE = "EP";
    private static final String USER_FLAG_PASSWORD = "PW";
    private static final String USER_FLAG_NAME = "NM";
    private static final String USER_FLAG_FAIL_TIME = "FT";

    @Autowired
    public SecurityUserService securityUserService;

    @Autowired
    public SecurityRoleDAO securityRoleDAO;

    @Autowired
    public SecurityUserRoleDAO securityUserRoleDAO;

    @Autowired
    public SecurityMenuDAO securityMenuDAO;

    @Autowired
    public SecurityMenuRoleDAO securityMenuRoleDAO;

    @Autowired
    public EncryptService encryptService;

    @Override
    public RespondSecurityAdminView listUsers() throws ApplicationException {

        RespondSecurityAdminView result = new RespondSecurityAdminView();

        result.setUsers(securityUserService.listUsers(false));
        return result;
    }

    @Override
    public RespondSecurityAdminView listActiveUsers() throws ApplicationException {

        RespondSecurityAdminView result = new RespondSecurityAdminView();

        result.setUsers(securityUserService.listUsers(true));
        return result;
    }

    @Override
    public RespondSecurityAdminView getUserById(Integer userNumericId) throws ApplicationException {

        SecurityUserBean user = securityUserService.getUserById(userNumericId, false);
        Preconditions.checkNotNull(user, "系统找不到指定的用户(user id:%s)", userNumericId);

        return new RespondSecurityAdminView(user);
    }

    @Override
    public RespondSecurityAdminView processLogin(Integer userNumericId, String password) throws ApplicationException {

        Preconditions.checkNotNull(userNumericId, "用户标识符不能为空");
        Preconditions.checkNotNull(password, "用户(user id:%s)密码不能为空", userNumericId);

        SecurityUserBean user = securityUserService.getUserById(userNumericId, true);
        Preconditions.checkNotNull(user, "系统找不到指定的用户(user id:%s)", userNumericId);

        RespondSecurityAdminView result = new RespondSecurityAdminView();

        if (!encryptService.encryptByMd5(password).equals(user.getPassword())) {
            throw new ApplicationException(ApplicationExceptionCode.EXCEPTION_CORE_USER_PASSWORD_NOT_MATCH);
        }
        result.setUser(user);

        return result;
    }

    @Override
    public RespondSecurityAdminView createUser(String userId, String userName, String password, String remark, Integer createUserId) throws ApplicationException {

        SecurityUserBean user = securityUserService.createUser(userId, userName, password, remark, createUserId);

        RespondSecurityAdminView result = new RespondSecurityAdminView();
        result.setUser(user);

        return result;
    }

    @Override
    public RespondSecurityAdminView updateUserEnableFlag(Integer updateUserId, Integer userNumericId, boolean isEnable, String remark) throws ApplicationException {

        SecurityUserBean user = setUserUpdateInfo(userNumericId, updateUserId, remark, USER_FLAG_ENABLE, ObjectUtils.convert2DbBoolean(isEnable));

        return new RespondSecurityAdminView(user);
    }

    @Override
    public RespondSecurityAdminView updateUserLockFlag(Integer updateUserId, Integer userNumericId, boolean isLock, String remark) throws ApplicationException {

        SecurityUserBean user = setUserUpdateInfo(userNumericId, updateUserId, remark, USER_FLAG_LOCK, ObjectUtils.convert2DbBoolean(isLock));

        return new RespondSecurityAdminView(user);
    }

    @Override
    public RespondSecurityAdminView updateUserExpireFlag(Integer updateUserId, Integer userNumericId, boolean isExpire, String remark) throws ApplicationException {

        SecurityUserBean user = setUserUpdateInfo(userNumericId, updateUserId, remark, USER_FLAG_EXPIRE, ObjectUtils.convert2DbBoolean(isExpire));

        return new RespondSecurityAdminView(user);
    }

    @Override
    public RespondSecurityAdminView updateUserActiveFlag(Integer updateUserId, Integer userNumericId, boolean isActive, String remark) throws ApplicationException {

        SecurityUserBean user = setUserUpdateInfo(userNumericId, updateUserId, remark, USER_FLAG_ACTIVE, ObjectUtils.convert2DbBoolean(isActive));

        return new RespondSecurityAdminView(user);
    }

    @Override
    public RespondSecurityAdminView updateUserLoginFailTimes(Integer updateUserId, Integer userNumericId, Integer failTimes, String remark) throws ApplicationException {

        SecurityUserBean user = setUserUpdateInfo(userNumericId, updateUserId, remark, USER_FLAG_FAIL_TIME, failTimes);

        return new RespondSecurityAdminView(user);
    }

    @Override
    public RespondSecurityAdminView updateUserName(Integer updateUserId, Integer userNumericId, String userName, String remark) throws ApplicationException {

        SecurityUserBean user = setUserUpdateInfo(userNumericId, updateUserId, remark, USER_FLAG_NAME, userName);

        return new RespondSecurityAdminView(user);
    }

    @Override
    public RespondSecurityAdminView updateUserPassword(Integer updateUserId, Integer userNumericId, String password, String remark) throws ApplicationException {

        SecurityUserBean user = setUserUpdateInfo(userNumericId, updateUserId, remark, USER_FLAG_PASSWORD, password);

        return new RespondSecurityAdminView(user);
    }

    private SecurityUserBean setUserUpdateInfo(Integer userNumericId, Integer updateUserId, String remark, String field, Object fieldValue) throws ApplicationException {

        SecurityUserBean user = securityUserService.getUserById(userNumericId, false);
        Preconditions.checkNotNull(user, "系统找不到指定的用户(user id:%s)", userNumericId);

        if (USER_FLAG_ENABLE.equalsIgnoreCase(field)) {
            user.setEnabled(String.valueOf(fieldValue));
        } else if (USER_FLAG_LOCK.equalsIgnoreCase(field)) {
            user.setLocked(String.valueOf(fieldValue));
        } else if (USER_FLAG_EXPIRE.equalsIgnoreCase(field)) {
            user.setExpired(String.valueOf(fieldValue));
        } else if (USER_FLAG_ACTIVE.equalsIgnoreCase(field)) {
            user.setActive(String.valueOf(fieldValue));
        } else if (USER_FLAG_FAIL_TIME.equalsIgnoreCase(field)) {
            user.setFailTimes(Integer.valueOf(field));
        } else if (USER_FLAG_NAME.equalsIgnoreCase(field)) {
            if (securityUserService.getUserByName(String.valueOf(fieldValue)) != null) {
                throw new ApplicationException(ApplicationExceptionCode.EXCEPTION_CORE_DATA_ALREADY_EXIST, "用户名 %s 已被使用", String.valueOf(fieldValue));
            }
            user.setUserName(String.valueOf(fieldValue));
        } else if (USER_FLAG_PASSWORD.equalsIgnoreCase(field)) {
            user.setPassword(encryptService.encryptByMd5(String.valueOf(fieldValue)));
        } else {
            return null;
        }

        user.setUpdateUserId(updateUserId);
        user.setUpdateTs(DateTimeUtils.getCurrentTime());
        if (!Strings.isNullOrEmpty(remark)) {
            user.setRemark(remark);
        }

        user = securityUserService.updateUser(user);

        return user;
    }

    @Override
    public SecurityRoleListView listRolesByUserId(Integer userNumericId) throws ApplicationException {

        Iterable<SecurityRoleBean> roles = securityUserRoleDAO.findActiveRolesByUserId(userNumericId);

        return new SecurityRoleListView(roles);
    }

    @Override
    public SecurityRoleBasicView saveUserRole(Integer userNumericId, Integer roleNumericId, String remark) throws ApplicationException {

        SecurityUserBean user = securityUserService.getUserById(userNumericId, true);
        Preconditions.checkNotNull(user, "系统找不到指定的用户(user id:%s), 无法保存其角色", userNumericId);

        SecurityRoleBean role = securityRoleDAO.findOne(roleNumericId);
        Preconditions.checkNotNull(role, "系统找不到指定的角色(role id:%s), 无法保存用户(user id:%s)角色", roleNumericId, userNumericId);

        SecurityUserRoleBean userRole = new SecurityUserRoleBean();
        userRole.setActive(SystemConstants.DB_RECORD_STRING_TRUE.getValue());
        userRole.setSecurityUserRolePrimaryKey(new SecurityUserRolePrimaryKey(user, role));
        userRole.setRemark(remark);

        securityUserRoleDAO.save(userRole);

        return new SecurityRoleBasicView(role);
    }

    @Override
    public SecurityRoleListView listRoles() throws ApplicationException {

        return new SecurityRoleListView(securityRoleDAO.findAll());
    }

    @Override
    @Cacheable(value = "securityAdminService", key = "'grbi.'.concat(#roleNumericId)")
    public SecurityRoleBasicView getRoleById(Integer roleNumericId) throws ApplicationException {

        SecurityRoleBean role = securityRoleDAO.findOne(roleNumericId);
        Preconditions.checkNotNull(role, "系统找不到指定的角色(role id:%s)", roleNumericId);

        return new SecurityRoleBasicView(role);
    }

    @Override
    public SecurityRoleBasicView createRole(String active, String intlId, String name, String remark) throws ApplicationException {

        SecurityRoleBean role = securityRoleDAO.findByIntlId(intlId);
        if (role != null) {
            throw new ApplicationException(ApplicationExceptionCode.EXCEPTION_CORE_DATA_ALREADY_EXIST, "角色内部ID %s 已被使用", intlId);
        }

        role = new SecurityRoleBean();
        role.setActive(active);
        role.setIntlId(intlId);
        role.setName(name);
        role.setRemark(remark);

        role = securityRoleDAO.save(role);

        return new SecurityRoleBasicView(role);
    }

    @Override
    public SecurityRoleBasicView updateRole(Integer roleNumericId, String active, String name, String remark) throws ApplicationException {

        SecurityRoleBean role = securityRoleDAO.findOne(roleNumericId);
        if (role == null) {
            throw new ApplicationException(ApplicationExceptionCode.EXCEPTION_CORE_DATA_NOT_FOUND);
        }

        role.setActive(active);
        role.setName(name);
        role.setRemark(remark);

        role = securityRoleDAO.save(role);

        return new SecurityRoleBasicView(role);
    }

    @Override
    public SecurityMenuListView listMenus() throws ApplicationException {
        return new SecurityMenuListView(securityMenuDAO.findAll());
    }

    @Override
    @Cacheable(value = "securityAdminService", key = "'gmbi.'.concat(#menuNumericId)")
    public SecurityMenuBasicView getMenuById(Integer menuNumericId) throws ApplicationException {
        SecurityMenuBean menuBean = securityMenuDAO.findOne(menuNumericId);
        if (menuBean == null) {
            throw new ApplicationException(ApplicationExceptionCode.EXCEPTION_CORE_DATA_NOT_FOUND);
        }

        return new SecurityMenuBasicView(menuBean);
    }


}
