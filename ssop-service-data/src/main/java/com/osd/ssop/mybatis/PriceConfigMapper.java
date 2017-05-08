package com.osd.ssop.mybatis;

import com.osd.ssop.entity.PriceConfig;

import java.util.List;

/**
 * Created by chenbinghao on 17/4/15.下午11:43
 */
public interface PriceConfigMapper {

    List<PriceConfig> queryPriceConfigs(int version);

    int queryMaxVersion();

}
