package com.osd.ssop.entity;

import java.util.Date;

/**
 * Created by chenbinghao on 16/8/27.
 */
public class User {

    private Integer accountId;

    private String account;

    private String password;

    private String name;

    private String mobile;

    private Integer canSendSmsCount;

    private Integer sentSmsCount;

    private Integer sex;

    private Integer roleType;

    private Date addTime;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getCanSendSmsCount() {
        return canSendSmsCount;
    }

    public void setCanSendSmsCount(Integer canSendSmsCount) {
        this.canSendSmsCount = canSendSmsCount;
    }

    public Integer getSentSmsCount() {
        return sentSmsCount;
    }

    public void setSentSmsCount(Integer sentSmsCount) {
        this.sentSmsCount = sentSmsCount;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
