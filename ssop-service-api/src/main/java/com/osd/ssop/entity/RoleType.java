package com.osd.ssop.entity;

import java.util.Arrays;
import java.util.List;

/**
 * Created by chenbinghao on 16/8/27.
 */
public enum RoleType {

    // 未知
    UNKONWN(0, Arrays.asList(0)),

    // 系统管理员
    SYSTEM(9, Arrays.asList(5, 7, 9)),

    // 管理员
    MANAGER(8, Arrays.asList(5, 7, 8)),

    // 普通成员
    USER(3, Arrays.asList(3, 5));

    private int roleType;

    private List<Integer> menuTypeList;

    RoleType(int roleType, List<Integer> menuTypeList) {
        this.menuTypeList = menuTypeList;
        this.roleType = roleType;
    }

    public int getRoleType() {
        return roleType;
    }

    public void setRoleType(int roleType) {
        this.roleType = roleType;
    }

    public static RoleType getRoleType(int type) {
        for (RoleType roleType : RoleType.values()) {
            if (roleType.roleType == type)
                return roleType;
        }
        return UNKONWN;
    }

    public List<Integer> getMenuTypeList() {
        return menuTypeList;
    }

    public void setMenuTypeList(List<Integer> menuTypeList) {
        this.menuTypeList = menuTypeList;
    }
}
