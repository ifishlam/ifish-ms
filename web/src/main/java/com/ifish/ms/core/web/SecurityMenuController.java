/*
 * Copyright (c) 2017. iFish Studio.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 * @author Angus Lam
 * @date 2017/10/22
 *
 *
 */

package com.ifish.ms.core.web;

import com.ifish.ms.base.web.BaseController;
import com.ifish.ms.core.exception.ApplicationException;
import com.ifish.ms.core.biz.service.SecurityAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/menus")
public class SecurityMenuController extends BaseController {

    @Autowired
    public SecurityAdminService securityAdminService;

    @GetMapping
    public Object listMenus() throws ApplicationException {

        return saveResult(securityAdminService.listMenus());
    }

    @GetMapping(value = "{id}")
    public Object getMenuById(@PathVariable int id) throws ApplicationException {

        return saveResult(securityAdminService.getMenuById(id));
    }
}
