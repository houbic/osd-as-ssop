package com.bink.tools;

import com.bink.entity.PriceConfig;
import com.bink.mybatis.PriceConfigMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by chenbinghao on 17/4/15.下午11:51
 */
public class MessageConfig implements ApplicationListener<ContextRefreshedEvent> {

    private Logger LOGGER = LoggerFactory.getLogger(MessageConfig.class);

    @Autowired
    private PriceConfigMapper priceConfigMapper;

    public static List<PriceConfig> priceConfigList = null;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        LOGGER.info("========================================================");
        LOGGER.info("======================Init config=======================");
        LOGGER.info("========================================================");

        priceConfigList = priceConfigMapper.queryPriceConfigs(priceConfigMapper.queryMaxVersion());

    }

    public synchronized static BigDecimal getBuyPrice(int count) {
        for (PriceConfig priceConfig : priceConfigList) {
            if (priceConfig.getStartCount() < count && count<= priceConfig.getEndCount()) {
                return priceConfig.getPrice();
            }
        }
        return null;
    }

}
