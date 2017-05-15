package com.osd.ssop.controller;

import com.alibaba.fastjson.JSONObject;
import com.osd.ssop.constant.ErrorCode;
import com.osd.ssop.entity.systemFrame.SystemApp;
import com.osd.ssop.entity.systemFrame.SystemUser;
import com.osd.ssop.fastjson.JsonMapper;
import com.osd.ssop.service.SystemFrameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by chenbinghao on 16/9/1.下午3:45
 */
@Controller
@RequestMapping("ssop")
public class SystemFrameController {

    @Autowired
    private SystemFrameService systemFrameService;

    private Logger logger = LoggerFactory.getLogger(SystemFrameController.class);

    @RequestMapping("login")
    public String login() {
        return "login";
    }

    @RequestMapping("jumpPage")
    public ModelAndView jumpPage(HttpServletRequest request, HttpServletResponse response) {
        HttpSession httpSession = request.getSession();
        String username = (String)httpSession.getAttribute("username");
        SystemUser user = systemFrameService.getSystemUser(username);
        List<SystemApp> apps = systemFrameService.getAppList(user);
        return new ModelAndView("jumpPage", "apps", apps);
    }

    @RequestMapping(value = "checkLogin", method = RequestMethod.POST)
    public void checkLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("userName");
        String password = request.getParameter("password");
        String inputCode = request.getParameter("code");
        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        String code = (String) session.getAttribute("codeValidate");
        if (inputCode == null || !inputCode.equalsIgnoreCase(code)){
            logger.error("inputCode:{}, session code:{}", inputCode, code);
            response.getWriter().print(ErrorCode.CODE_VALIDATE_ERROR.getCode());
            return;
        }
        int resultCode = systemFrameService.checkLogin(username, password);
        logger.info("login status :{}", resultCode);
        JSONObject json = new JSONObject();
        json.put("code", resultCode);
        response.getWriter().print(JsonMapper.toJson(json));

    }

    @RequestMapping("LogOut")
    public String logOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession httpSession = request.getSession();
        String username = (String)httpSession.getAttribute("username");
        logger.info("user[{}] logOut", username);
        httpSession.invalidate();
        return "login";
    }


}
