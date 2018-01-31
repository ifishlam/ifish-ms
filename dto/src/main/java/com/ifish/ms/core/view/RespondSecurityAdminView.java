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

package com.ifish.ms.core.view;

import com.ifish.ms.base.view.RespondBaseView;
import com.ifish.ms.core.bean.SecurityMenuBean;
import com.ifish.ms.core.bean.SecurityRoleBean;
import com.ifish.ms.core.bean.SecurityUserBean;

public class RespondSecurityAdminView extends RespondBaseView {

    SecurityUserBasicView user;

    SecurityUserListView users;

    SecurityRoleBasicView role;

    SecurityRoleListView roles;

    SecurityMenuBasicView menu;

    SecurityMenuListView menus;

    public RespondSecurityAdminView() {
    }

    public RespondSecurityAdminView(SecurityUserBean user) {
        setUser(user);
    }

    public SecurityUserBasicView getUser() {
        return user;
    }

    public void setUser(SecurityUserBasicView user) {
        this.user = user;
    }

    public void setUser(SecurityUserBean user) {
        this.user = new SecurityUserBasicView(user);
    }

    public SecurityUserListView getUsers() {
        return users;
    }

    public void setUsers(SecurityUserListView users) {
        this.users = users;
    }

    public void setUsers(Iterable<SecurityUserBean> users) {
        this.users = new SecurityUserListView(users);
    }

    public SecurityRoleBasicView getRole() {
        return role;
    }

    public void setRole(SecurityRoleBasicView role) {
        this.role = role;
    }

    public void setRole(SecurityRoleBean role) {
        this.role = new SecurityRoleBasicView(role);
    }

    public SecurityRoleListView getRoles() {
        return roles;
    }

    public void setRoles(SecurityRoleListView roles) {
        this.roles = roles;
    }

    public void setRoles(Iterable<SecurityRoleBean> roles) {
        this.roles = new SecurityRoleListView(roles);
    }

    public SecurityMenuBasicView getMenu() {
        return menu;
    }

    public void setMenu(SecurityMenuBasicView menu) {
        this.menu = menu;
    }

    public void setMenu(SecurityMenuBean menu) {
        this.menu = new SecurityMenuBasicView(menu);
    }

    public SecurityMenuListView getMenus() {
        return menus;
    }

    public void setMenus(SecurityMenuListView menus) {
        this.menus = menus;
    }

    public void setMenus(Iterable<SecurityMenuBean> menus) {
        this.menus = new SecurityMenuListView(menus);
    }
}
