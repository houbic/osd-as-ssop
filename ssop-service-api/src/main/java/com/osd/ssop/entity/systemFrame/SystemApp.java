package com.osd.ssop.entity.systemFrame;

/**
 * Created by chenbinghao on 17/5/12.下午4:07
 */
public class SystemApp {

    // 系统id
    private String systemId;

    // 系统名称
    private String systemName;

    // 链接Url
    private String url;

    // 是否显示
    private boolean isDisplay;

    // 是否是权限项
    private boolean isRight;

    // 备注
    private String remark;

    // 显示顺序
    private int index;

    // 背景图片
    private String bgImg;

    // 显示图标
    private String icoImg;

    // 退出Url
    private String logOutUrl;

    // 是否预设系统
    private boolean isDefault;

    // 登录是否已删除
    private boolean isLogicDel;

    public String getSystemId() {
        return systemId;
    }

    public void setSystemId(String systemId) {
        this.systemId = systemId;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isDisplay() {
        return isDisplay;
    }

    public void setDisplay(boolean display) {
        isDisplay = display;
    }

    public boolean isRight() {
        return isRight;
    }

    public void setRight(boolean right) {
        isRight = right;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getBgImg() {
        return bgImg;
    }

    public void setBgImg(String bgImg) {
        this.bgImg = bgImg;
    }

    public String getIcoImg() {
        return icoImg;
    }

    public void setIcoImg(String icoImg) {
        this.icoImg = icoImg;
    }

    public String getLogOutUrl() {
        return logOutUrl;
    }

    public void setLogOutUrl(String logOutUrl) {
        this.logOutUrl = logOutUrl;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public boolean isLogicDel() {
        return isLogicDel;
    }

    public void setLogicDel(boolean logicDel) {
        isLogicDel = logicDel;
    }
}
