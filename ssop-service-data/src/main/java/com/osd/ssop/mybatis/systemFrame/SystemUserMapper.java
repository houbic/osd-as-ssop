package com.osd.ssop.mybatis.systemFrame;

import com.osd.ssop.entity.systemFrame.SystemUser;

/**
 * Created by chenbinghao on 17/4/15.下午9:10
 */
public interface SystemUserMapper {

    SystemUser getSystemUser(String loginName);

}
