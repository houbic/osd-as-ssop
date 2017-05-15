package com.osd.ssop.entity.systemFrame;

/**
 * Created by chenbinghao on 17/5/12.下午4:04
 */
public class SystemRole {

    // 角色id
    private String roleId;

    // 系统id
    private String systemId;

    // 角色名称
    private String roleName;

    // 角色备注
    private String roleRemark;

    // 是否已删除
    private String isDel;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getIsDel() {
        return isDel;
    }

    public void setIsDel(String isDel) {
        this.isDel = isDel;
    }

    public String getRoleRemark() {
        return roleRemark;
    }

    public void setRoleRemark(String roleRemark) {
        this.roleRemark = roleRemark;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }
}
