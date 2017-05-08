package com.osd.ssop.services;

import com.osd.ssop.entity.SmsSendRecord;
import com.osd.ssop.entity.User;
import com.osd.ssop.fastjson.JsonMapper;
import com.osd.ssop.mybatis.SendRecordMapper;
import com.osd.ssop.service.SmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by chenbinghao on 17/4/15.下午10:42
 */
@Component("smsService")
public class SmsServiceImpl implements SmsService {

    private Logger LOGGER = LoggerFactory.getLogger(SmsServiceImpl.class);

    @Autowired
    private SendRecordMapper sendRecordMapper;

    @Override
    public List<SmsSendRecord> getSmsSendRecord(User user) {
        List<SmsSendRecord> sendRecordList = sendRecordMapper.querySendRecord(user.getAccountId());
        LOGGER.info("sendRecordList:{}", JsonMapper.toJson(sendRecordList));
        return sendRecordList;
    }
}
