package com.bink.service;

import com.bink.entity.SmsSendRecord;
import com.bink.entity.User;

import java.util.List;

/**
 * Created by chenbinghao on 17/4/15.下午9:03
 */
public interface SmsService {

    List<SmsSendRecord> getSmsSendRecord(User user);

}
