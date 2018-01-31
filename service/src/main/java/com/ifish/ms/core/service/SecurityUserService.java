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

package com.ifish.ms.core.service;

import com.ifish.ms.core.bean.SecurityUserBean;
import com.ifish.ms.core.exception.ApplicationException;
import java.util.List;

public interface SecurityUserService {

    /**
     * Get all the users with basic information
     *
     * @param isActiveOnly true to get active users only
     * @return Iterable<SecurityUserBean>
     * @throws ApplicationException if have error
     */
    Iterable<SecurityUserBean> listUsers(boolean isActiveOnly) throws ApplicationException;


    /**
     * Get all the users with basic information
     *
     * @param idList list of id
     * @return Iterable<SecurityUserBean>
     * @throws ApplicationException if have error
     */
    Iterable<SecurityUserBean> listUsersByIdList(List<Integer> idList) throws ApplicationException;

    /**
     * Get all the users with basic information
     *
     * @param userIdList list of user id
     * @return Iterable<SecurityUserBean>
     * @throws ApplicationException if have error
     */
    Iterable<SecurityUserBean> listUsersByUserIdList(List<String> userIdList) throws ApplicationException;

    /**
     * Get user basic information by user numeric id
     *
     * @param userNumericId Integer id of table security_user
     * @param isActiveOnly true to get active user only
     * @return SecurityUserBean
     * @throws ApplicationException if have error
     */
    SecurityUserBean getUserById(Integer userNumericId, boolean isActiveOnly) throws ApplicationException;

    /**
     * Get user basic information by user id
     *
     * @param userId String
     * @param isActiveOnly true to get active user only
     * @return SecurityUserBean
     * @throws ApplicationException
     */
    SecurityUserBean getUserByUserId(String userId, boolean isActiveOnly) throws ApplicationException;

    /**
     * Get user basic information by user name
     *
     * @param userName String
     * @return SecurityUserBean
     * @throws ApplicationException
     */
    SecurityUserBean getUserByName(String userName) throws ApplicationException;

    /**
     * Create a new user
     *
     * @param userId String user id
     * @param userName String user name
     * @param password String password
     * @param remark String remark
     * @param createUserId Integer id of table security_user
     * @return SecurityUserBean
     * @throws ApplicationException if have error
     */
    SecurityUserBean createUser(String userId, String userName, String password, String remark, Integer createUserId) throws ApplicationException;

    /**
     * Update an user
     *
     * @param user SecurityUserBean object
     * @return SecurityUserBean
     * @throws ApplicationException if have error
     */
    SecurityUserBean updateUser(SecurityUserBean user) throws ApplicationException;

}
