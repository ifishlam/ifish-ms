/*
 * Copyright (c) 2017. iFish Studio.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 * @author Angus Lam
 * @date 2017/11/4
 *
 *
 */

package com.ifish.ms.core.service.impl;

import com.google.common.base.Preconditions;
import com.ifish.ms.core.bean.SecurityUserBean;
import com.ifish.ms.core.biz.service.EncryptService;
import com.ifish.ms.core.dao.SecurityUserDAO;
import com.ifish.ms.core.exception.ApplicationException;
import com.ifish.ms.core.exception.ApplicationExceptionCode;
import com.ifish.ms.core.service.SecurityUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("securityUserService")
public class SecurityUserServiceImpl implements SecurityUserService {

    @Autowired
    public SecurityUserDAO securityUserDAO;

    @Autowired
    public EncryptService encryptService;

    @Override
    public Iterable<SecurityUserBean> listUsers(boolean isActiveOnly) throws ApplicationException {

        return isActiveOnly ? securityUserDAO.findAll4Active() : securityUserDAO.findAll();
    }

    @Override
    public Iterable<SecurityUserBean> listUsersByIdList(List<Integer> idList) throws ApplicationException {

        return securityUserDAO.findAllByIdIn(idList);
    }

    @Override
    public Iterable<SecurityUserBean> listUsersByUserIdList(List<String> userIdList) throws ApplicationException {

        return securityUserDAO.findAllByUserIdIn(userIdList);
    }

    @Override
    @Cacheable(value = "securityUserService", key = "#userNumericId")
    public SecurityUserBean getUserById(Integer userNumericId, boolean isActiveOnly) throws ApplicationException {

        return isActiveOnly ? securityUserDAO.findOne4Active(userNumericId) : securityUserDAO.findOne(userNumericId);
    }

    @Override
    public SecurityUserBean getUserByUserId(String userId, boolean isActiveOnly) throws ApplicationException {

        return isActiveOnly ? securityUserDAO.findByUserId4Active(userId) : securityUserDAO.findByUserId(userId);
    }

    @Override
    public SecurityUserBean getUserByName(String userName) throws ApplicationException {

        return securityUserDAO.findByUserName(userName);
    }

    @Override
    public SecurityUserBean createUser(String userId, String userName, String password, String remark, Integer createUserId) throws ApplicationException {

        Preconditions.checkNotNull(userId, "创建新用户时,用户ID不能为空");
        Preconditions.checkNotNull(userName, "创建新用户时,用户名不能为空");
        Preconditions.checkNotNull(password, "创建新用户时,用户密码不能为空");

        SecurityUserBean user = this.getUserByUserId(userId, false);
        if (user != null) {
            throw new ApplicationException(ApplicationExceptionCode.EXCEPTION_CORE_DATA_ALREADY_EXIST, "用户ID %s 已被使用", userId);
        }

        if (this.getUserByName(userName) != null) {
            throw new ApplicationException(ApplicationExceptionCode.EXCEPTION_CORE_DATA_ALREADY_EXIST, "用户名 %s 已被使用", userName);
        }

        user = new SecurityUserBean(userId, userName, encryptService.encryptByMd5(password), createUserId, createUserId, remark);

        user = securityUserDAO.save(user);

        return user;
    }

    @Override
    @CacheEvict(value = "securityUserService", key = "#user.id", beforeInvocation = true)
    public SecurityUserBean updateUser(SecurityUserBean user) throws ApplicationException {

        Preconditions.checkNotNull(user, "用户对象无效");

        user = securityUserDAO.save(user);
        return user;
    }

}
