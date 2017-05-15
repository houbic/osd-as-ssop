package com.osd.ssop.mybatis.systemFrame;

import com.osd.ssop.entity.systemFrame.SystemApp;

import java.util.List;

/**
 * Created by chenbinghao on 17/4/15.下午9:10
 */
public interface SystemAppMapper {

    List<SystemApp> getSystemApp(List<String> systemIds);

}
