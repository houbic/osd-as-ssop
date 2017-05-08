package com.osd.ssop.services;

import com.osd.ssop.service.ManagerService;
import com.osd.ssop.entity.Menu;
import com.osd.ssop.entity.RoleType;
import com.osd.ssop.entity.User;
import com.osd.ssop.mybatis.MenuMapper;
import com.osd.ssop.mybatis.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by chenbinghao on 16/8/27.
 */
@Component("managerService")
public class ManagerServiceImpl implements ManagerService{

    @Autowired
    public UserMapper userMapper;

    @Autowired
    public MenuMapper menuMapper;

    public User getUserByName(String userName) {
        return userMapper.getUserByName(userName);
    }

    public List<Menu> getMenuByRoleType(int roleType) {
        System.out.println("begin to get menu.........." + roleType);
        return menuMapper.getMenuByRoleType(RoleType.getRoleType(roleType).getMenuTypeList());
    }

}
