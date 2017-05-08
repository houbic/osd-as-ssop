package com.osd.ssop.services;

import com.osd.ssop.service.UserService;
import com.osd.ssop.constant.ErrorCode;
import com.osd.ssop.entity.InputUser;
import com.osd.ssop.entity.User;
import com.osd.ssop.mybatis.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Created by chenbinghao on 16/9/1.
 */
@Component
public class UserServiceImpl implements UserService {

    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    public int checkLogin(InputUser inputUser) {

        if (StringUtils.isEmpty(inputUser.getUserName()))
            return ErrorCode.USER_LOGIN_USERNAME_ERROR.getCode();

        User user = userMapper.getUserByName(inputUser.getUserName());
        if (user == null)
            return ErrorCode.USER_LOGIN_USERNAME_ERROR.getCode();

        if (inputUser.getPassword().equals(user.getPassword()))
            return ErrorCode.USER_LOGIN_SUCCESS.getCode();
        else
            return ErrorCode.USER_LOGIN_PASSWORD_ERROR.getCode();

    }

    public int checkLogin(String userName, String password) {

        if (StringUtils.isEmpty(userName)) {
            return ErrorCode.USER_LOGIN_USERNAME_ERROR.getCode();
        }

        User user = userMapper.getUserByName(userName);
        if (user == null) {
            return ErrorCode.USER_LOGIN_USERNAME_ERROR.getCode();
        }

        if (password.equals(user.getPassword())) {
            return ErrorCode.USER_LOGIN_SUCCESS.getCode();
        } else {
            return ErrorCode.USER_LOGIN_PASSWORD_ERROR.getCode();
        }

    }

}
