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

package com.ifish.ms.core.dao;

import com.ifish.ms.base.dao.BaseDAO;
import com.ifish.ms.core.bean.SecurityUserBean;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityUserDAO extends BaseDAO<SecurityUserBean, Integer> {

    /**
     * Find all active users
     *
     * @return
     */
    @Query("select t from SecurityUserBean t where t.active = '+'")
    Iterable<SecurityUserBean> findAll4Active();

    /**
     * Find users by list of id
     *
     * @param idList
     * @return
     */
    Iterable<SecurityUserBean> findAllByIdIn(List<Integer> idList);

    /**
     * Find users by list of user id
     *
     * @param userIdList
     * @return
     */
    Iterable<SecurityUserBean> findAllByUserIdIn(List<String> userIdList);


    /**
     * Find active user by id
     *
     * @param userNumericId
     * @return
     */
    @Query("select t from SecurityUserBean t where t.active = '+' and t.id = :userNumericId")
    SecurityUserBean findOne4Active(@Param("userNumericId") Integer userNumericId);

    /**
     * Find user by user_id
     *
     * @param userId
     * @return
     */
    SecurityUserBean findByUserId(String userId);

    /**
     * Find active user by user_id
     *
     * @param userId
     * @return
     */
    @Query("select t from SecurityUserBean t where t.active = '+' and t.userId = :userId")
    SecurityUserBean findByUserId4Active(@Param("userId") String userId);

    /**
     * Find user by user name
     *
     * @param userName
     * @return
     */
    SecurityUserBean findByUserName(String userName);
}
