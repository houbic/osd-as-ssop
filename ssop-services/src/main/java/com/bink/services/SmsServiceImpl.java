package com.bink.services;

import com.bink.entity.SmsSendRecord;
import com.bink.entity.User;
import com.bink.fastjson.JsonMapper;
import com.bink.mybatis.SendRecordMapper;
import com.bink.service.SmsService;
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
