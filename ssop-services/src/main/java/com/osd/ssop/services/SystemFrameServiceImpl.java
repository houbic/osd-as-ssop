package com.osd.ssop.services;

import com.osd.ssop.constant.ErrorCode;
import com.osd.ssop.entity.systemFrame.RoleUser;
import com.osd.ssop.entity.systemFrame.SystemApp;
import com.osd.ssop.entity.systemFrame.SystemRole;
import com.osd.ssop.entity.systemFrame.SystemUser;
import com.osd.ssop.fastjson.JsonMapper;
import com.osd.ssop.mybatis.systemFrame.RoleUserMapper;
import com.osd.ssop.mybatis.systemFrame.SystemAppMapper;
import com.osd.ssop.mybatis.systemFrame.SystemRoleMapper;
import com.osd.ssop.mybatis.systemFrame.SystemUserMapper;
import com.osd.ssop.service.SystemFrameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenbinghao on 17/5/11.下午2:06
 */
@Component("systemFrameService")
public class SystemFrameServiceImpl implements SystemFrameService {

    @Autowired
    private SystemUserMapper userMapper;

    @Autowired
    private SystemRoleMapper roleMapper;

    @Autowired
    private SystemAppMapper appMapper;

    @Autowired
    private RoleUserMapper roleUserMapper;

    private Logger logger = LoggerFactory.getLogger(SystemFrameServiceImpl.class);

    @Override
    public SystemUser getSystemUser(String loginName) {
        return userMapper.getSystemUser(loginName);
    }

    @Override
    public int checkLogin(String loginName, String password) {
        SystemUser user = getSystemUser(loginName);
        if (user == null) {
            logger.error("user[{}] is not exists", loginName);
            return ErrorCode.USER_NOTEXISTS_ERROR.getCode();
        }
        String pwd = user.getPassword();
        // TODO: 17/5/11 需要看源代码加密方式
//        if (pwd.equals(password)) {
//            return ErrorCode.USER_LOGIN_SUCCESS.getCode();
//        }
        return ErrorCode.USER_LOGIN_SUCCESS.getCode();
    }

    /**
     * 根据登录名获取系统列表
     * @param user
     * @return
     */
    @Override
    public List<SystemApp> getAppList(SystemUser user) {
        logger.info("begin to get user[{}] app list", user.getUserId());
        List<RoleUser> roleUsers = roleUserMapper.getRoleUserList(user.getUserId());
        if (roleUsers == null) {
            logger.warn("user[{}] roleIds is empty", user.getUserId());
            return null;
        }
        logger.info("user[{}] roleIds:{}", user.getUserId(), JsonMapper.toJson(roleUsers));
        List<String> roleIds = new ArrayList<>();
        roleUsers.forEach(roleUser -> roleIds.add(roleUser.getRoleId()));
        List<SystemRole> roles = roleMapper.getRoleList(roleIds);
        if (roles == null) {
            logger.warn("user[{}] roles is empty", user.getUserId());
            return null;
        }
        logger.info("user[{}] roles:{}", user.getUserId(), JsonMapper.toJson(roles));
        List<String> systemIds = new ArrayList<>();
        roles.forEach(role -> systemIds.add(role.getSystemId()));
        List<SystemApp> apps = appMapper.getSystemApp(systemIds);
        logger.info("user[{}] apps:{}", user.getUserId(), JsonMapper.toJson(apps));
        return apps;
    }
}
