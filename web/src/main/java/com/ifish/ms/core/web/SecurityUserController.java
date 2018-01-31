/*
 * Copyright (c) 2017. iFish Studio.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 * @author Angus Lam
 * @date 2017/10/20
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class SecurityUserController extends BaseController {

    @Autowired
    public SecurityAdminService securityAdminService;

    @GetMapping
    public Object listUsers() throws ApplicationException {

        return saveResult(securityAdminService.listUsers());
    }

    @GetMapping(value = "{id}")
    public Object getUserById(@PathVariable int id) throws ApplicationException {

        return saveResult(securityAdminService.getUserById(id));
    }

    @PostMapping
    public Object createUser(@NotBlank String userId, @NotBlank String userName, @NotBlank String password, String remark, @NotBlank int createUserId) throws ApplicationException {

        return saveResult(securityAdminService.createUser(userId, userName, password, remark, createUserId));
    }

    @PutMapping(value = "{id}/active")
    public Object updateUserActiveFlag(@PathVariable int id, @NotBlank int updateUserId, @NotBlank String isActive, String remark) throws ApplicationException {

        return saveResult(securityAdminService.updateUserActiveFlag(updateUserId, id, isActive == "+" ? true : false, remark));
    }

    @PutMapping(value = "{id}/enable")
    public Object updateUserEnableFlag(@PathVariable int id, @NotBlank int updateUserId, @NotBlank String isEnable, String remark) throws ApplicationException {

        return saveResult(securityAdminService.updateUserEnableFlag(updateUserId, id, isEnable == "+" ? true : false, remark));
    }

    @PutMapping(value = "{id}/password")
    public Object updateUserPassword(@PathVariable int id, @NotBlank int updateUserId, @NotBlank String password, String remark) throws ApplicationException {

        return saveResult(securityAdminService.updateUserPassword(updateUserId, id, password, remark));
    }

    @PutMapping(value = "{id}/name")
    public Object updateUserName(@PathVariable int id, @NotBlank int updateUserId, @NotBlank String name, String remark) throws ApplicationException {

        return saveResult(securityAdminService.updateUserName(updateUserId, id, name, remark));
    }

    @GetMapping(value = "{id}/roles")
    public Object listRolesByUserId(@PathVariable int id) throws ApplicationException {

        return saveResult(securityAdminService.listRolesByUserId(id));
    }

    @PostMapping(value = "{id}/role")
    public Object saveUserRole(@PathVariable int id, @NotBlank int roleId, @RequestParam String remark) throws ApplicationException {

        return saveResult(securityAdminService.saveUserRole(id, roleId, remark));
    }

}
