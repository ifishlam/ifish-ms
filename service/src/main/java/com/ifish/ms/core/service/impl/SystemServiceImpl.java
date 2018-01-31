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

package com.ifish.ms.core.service.impl;

import com.ifish.ms.core.bean.SystemPropertyBean;
import com.ifish.ms.core.dao.SystemPropertyDAO;
import com.ifish.ms.core.service.SystemService;
import com.ifish.ms.core.util.SystemConstants;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service("systemService")
public class SystemServiceImpl implements SystemService {

    @Autowired
    public SystemPropertyDAO systemPropertyDAO;

    @Cacheable(value = "systemService", key = "'gasp.'.concat(#propertyKey)")
    @Override
    public String getActiveSystemProperty(String propertyKey) {

        System.err.println("getSystemProperty");
        String result = null;

        SystemPropertyBean bean = systemPropertyDAO.findOne(propertyKey);
        if (bean != null) {
            result = bean.getValue();
        }

        return result;
    }

    @Override
    public Map<String, String> listActiveSystemProperty() {

        return listSystemProperty(true, false);
    }

    @Override
    public Map<String, String> listInactiveSystemProperty() {

        return listSystemProperty(false, false);
    }

    @Override
    public Map<String, String> listAllSystemProperty() {

        return listSystemProperty(true, true);
    }

    private Map<String, String> listSystemProperty(boolean isActive, boolean isAll) {

        Map<String, String> result = null;

        Iterable<SystemPropertyBean> propertyList = null;

        if (isAll) {
            propertyList = systemPropertyDAO.findAll();
        } else {
            if (isActive) {
                propertyList = systemPropertyDAO.findAllByActive(SystemConstants.DB_RECORD_STRING_TRUE.getValue());
            } else {
                propertyList = systemPropertyDAO.findAllByActive(null);
            }
        }

        if (propertyList != null) {
            result = new HashMap<>();
            for (SystemPropertyBean bean : propertyList) {
                result.put(bean.getKey(), bean.getValue());
            }
        }

        return result;
    }

}
