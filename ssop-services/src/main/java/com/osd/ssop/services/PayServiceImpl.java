package com.osd.ssop.services;

import com.osd.ssop.entity.SmsBuyRecord;
import com.osd.ssop.entity.User;
import com.osd.ssop.fastjson.JsonMapper;
import com.osd.ssop.mybatis.BuyRecordMapper;
import com.osd.ssop.service.PayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by chenbinghao on 17/4/15.下午9:04
 */
@Component("payService")
public class PayServiceImpl implements PayService {

    private static Logger LOGGER = LoggerFactory.getLogger(PayServiceImpl.class);

    @Autowired
    private BuyRecordMapper buyRecordMapper;

    @Override
    public List<SmsBuyRecord> getSmsBuyRecord(User user) {
        List<SmsBuyRecord> smsBuyRecordList = buyRecordMapper.queryBuyRecord(user.getAccountId());
        LOGGER.info("sms buy record:{}", JsonMapper.toJson(smsBuyRecordList));
        return smsBuyRecordList;
    }
}