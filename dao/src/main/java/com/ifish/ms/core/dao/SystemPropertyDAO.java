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
import com.ifish.ms.core.bean.SystemPropertyBean;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemPropertyDAO extends BaseDAO<SystemPropertyBean, String> {

    public Iterable<SystemPropertyBean> findAllByActive(String active);

}
