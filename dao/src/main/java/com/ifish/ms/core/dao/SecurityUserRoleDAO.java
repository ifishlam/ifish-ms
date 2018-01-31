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
import com.ifish.ms.core.bean.SecurityRoleBean;
import com.ifish.ms.core.bean.SecurityUserRoleBean;
import com.ifish.ms.core.bean.SecurityUserRolePrimaryKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityUserRoleDAO extends BaseDAO<SecurityUserRoleBean, SecurityUserRolePrimaryKey> {

    @Query("select r from SecurityUserRoleBean ur, SecurityUserBean u, SecurityRoleBean r " +
        " where ur.securityUserRolePrimaryKey.securityUser.id = u.id " +
        " and ur.securityUserRolePrimaryKey.securityRole.id = r.id " +
        " and u.active = '+' and r.active = '+' " +
        " and u.id = ?1")
    Iterable<SecurityRoleBean> findActiveRolesByUserId(Integer userId);

}
