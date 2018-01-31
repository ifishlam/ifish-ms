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
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface SecurityRoleDAO extends BaseDAO<SecurityRoleBean, Integer> {

//    @Query("select t from SecurityRoleBean t where t.active = '+' and id = :id ")
//    SecurityRoleBean findActiveOne(@Param("id") Integer id);

    SecurityRoleBean findByActiveIsAndIdIs(String active, Integer id);

    Iterable<SecurityRoleBean> findAllByActiveIsAndIdIn(String active, List<Integer> ids);

    SecurityRoleBean findByIntlId(String intlId);
}
