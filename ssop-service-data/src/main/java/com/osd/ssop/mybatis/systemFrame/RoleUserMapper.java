package com.osd.ssop.mybatis.systemFrame;

import com.osd.ssop.entity.systemFrame.RoleUser;
import com.osd.ssop.entity.systemFrame.SystemRole;

import java.util.List;

/**
 * Created by chenbinghao on 17/4/15.下午9:10
 */
public interface RoleUserMapper {

    List<RoleUser> getRoleUserList(String userId);

}
