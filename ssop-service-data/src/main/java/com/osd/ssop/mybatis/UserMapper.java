package com.osd.ssop.mybatis;

import com.osd.ssop.entity.User;

/**
 * Created by chenbinghao on 16/8/31.
 */
public interface UserMapper {

    User getUserByName(String userName);

}
