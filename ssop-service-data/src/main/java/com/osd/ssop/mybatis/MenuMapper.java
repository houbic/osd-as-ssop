package com.osd.ssop.mybatis;

import com.osd.ssop.entity.Menu;

import java.util.List;

/**
 * Created by chenbinghao on 16/8/31.
 */
public interface MenuMapper {

    List<Menu> getMenuByRoleType(List<Integer> roleList);

}
