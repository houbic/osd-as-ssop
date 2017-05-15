package com.osd.ssop.mybatis.systemFrame;

import com.osd.ssop.entity.systemFrame.SystemRole;

import java.util.List;

/**
 * Created by chenbinghao on 17/4/15.下午9:10
 */
public interface SystemRoleMapper {

    List<SystemRole> getRoleList(List<String> roleIds);

}
