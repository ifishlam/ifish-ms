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
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
public class SecurityRoleController extends BaseController {

    @Autowired
    public SecurityAdminService securityAdminService;

    @GetMapping
    public Object listRoles() throws ApplicationException {

        return saveResult(securityAdminService.listRoles());
    }

    @GetMapping(value = "{id}")
    public Object getRoleById(@PathVariable int id) throws ApplicationException {

        return saveResult(securityAdminService.getRoleById(id));
    }

    @PostMapping
    public Object createRole(@RequestParam String active, @NotBlank String intlId, @NotBlank String name, @RequestParam String remark) throws ApplicationException {

        return saveResult(securityAdminService.createRole(active, intlId, name, remark));
    }

    @PostMapping(value = "{id}")
    public Object updateRole(@NotBlank int id, @RequestParam String active, @RequestParam String name, @RequestParam String remark) throws ApplicationException {

        return saveResult(securityAdminService.updateRole(id, active, name, remark));
    }

}
