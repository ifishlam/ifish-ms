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

package com.ifish.ms.core.bean;

import com.ifish.ms.base.bean.BaseBean;
import com.ifish.ms.core.util.DateTimeUtils;
import com.ifish.ms.core.util.SystemConstants;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "security_user")
public class SecurityUserBean extends BaseBean {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer id;

    @Column(name = "active")
    private String active;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private String enabled;

    @Column(name = "locked")
    private String locked;

    @Column(name = "expired")
    private String expired;

    @Column(name = "fail_times")
    private int failTimes;

    @Column(name = "create_ts")
    private Timestamp createTs;

    @Column(name = "create_user_id")
    private int createUserId;

    @Column(name = "update_ts")
    private Timestamp updateTs;

    @Column(name = "update_user_id")
    private int updateUserId;

    @Column(name = "remark")
    private String remark;

    public SecurityUserBean() {
    }

    public SecurityUserBean(String userId, String userName, String password, Integer createUserId, Integer updateUserId, String remark) {

        this.active = SystemConstants.DB_RECORD_STRING_TRUE.getValue();
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.enabled = SystemConstants.DB_RECORD_STRING_TRUE.getValue();
        this.locked = SystemConstants.DB_RECORD_STRING_FALSE.getValue();
        this.expired = SystemConstants.DB_RECORD_STRING_FALSE.getValue();
        this.failTimes = 0;
        this.createTs = DateTimeUtils.getCurrentTime();
        this.createUserId = createUserId;
        this.updateUserId = updateUserId;
        this.updateTs = DateTimeUtils.getCurrentTime();
        this.remark = remark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    public String getLocked() {
        return locked;
    }

    public void setLocked(String locked) {
        this.locked = locked;
    }

    public String getExpired() {
        return expired;
    }

    public void setExpired(String expired) {
        this.expired = expired;
    }

    public int getFailTimes() {
        return failTimes;
    }

    public void setFailTimes(int failTimes) {
        this.failTimes = failTimes;
    }

    public Timestamp getCreateTs() {
        return createTs;
    }

    public void setCreateTs(Timestamp createTs) {
        this.createTs = createTs;
    }

    public int getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(int createUserId) {
        this.createUserId = createUserId;
    }

    public Timestamp getUpdateTs() {
        return updateTs;
    }

    public void setUpdateTs(Timestamp updateTs) {
        this.updateTs = updateTs;
    }

    public int getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(int updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
