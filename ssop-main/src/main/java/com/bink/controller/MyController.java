package com.bink.controller;

import com.bink.entity.User;
import com.bink.service.ManagerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by chenbinghao on 17/4/16.下午4:26
 */
public interface MyController {

    default User getUser(HttpServletRequest request, ManagerService managerService) {
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        User user = managerService.getUserByName(username);
        return user;
    }

}
