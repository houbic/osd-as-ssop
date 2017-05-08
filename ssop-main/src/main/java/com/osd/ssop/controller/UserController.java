package com.osd.ssop.controller;

import com.osd.ssop.service.ManagerService;
import com.osd.ssop.service.UserService;
import com.osd.ssop.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by chenbinghao on 16/9/1.下午3:45
 */
@Controller
@RequestMapping("message")
public class UserController {

    @Autowired
    private ManagerService managerService;

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "checkLogin", method = RequestMethod.POST)
    public void checkLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        logger.info("===================username:{}, password:{}", username, password);
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        logger.debug("session id :{}", session.getId());
        int resultCode = userService.checkLogin(username, password);
        response.getWriter().print(resultCode);

    }

    @RequestMapping("LogOut")
    public String logOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession httpSession = request.getSession();
        String username = (String)httpSession.getAttribute("username");
        logger.info("user[{}] logOut", username);
        httpSession.invalidate();
        return "login";
    }

    @RequestMapping("user/user_info")
    public ModelAndView userInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        User user = managerService.getUserByName(username);
        ModelAndView mv;
        if (user == null) {
            mv = new ModelAndView("login");
        } else {
            mv = new ModelAndView("user/user_info", "user", user);
        }
        return mv;
    }

}