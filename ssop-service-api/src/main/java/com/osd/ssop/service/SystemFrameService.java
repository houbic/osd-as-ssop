package com.osd.ssop.service;

import com.osd.ssop.entity.systemFrame.SystemApp;
import com.osd.ssop.entity.systemFrame.SystemUser;

import java.util.List;

/**
 * Created by chenbinghao on 17/5/11.下午2:04
 */
public interface SystemFrameService {

    SystemUser getSystemUser(String loginName);

    int checkLogin(String loginName, String password);

    List<SystemApp> getAppList(SystemUser user);

}
