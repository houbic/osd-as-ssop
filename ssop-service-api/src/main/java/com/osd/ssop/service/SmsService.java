package com.osd.ssop.service;

import com.osd.ssop.entity.SmsSendRecord;
import com.osd.ssop.entity.User;

import java.util.List;

/**
 * Created by chenbinghao on 17/4/15.下午9:03
 */
public interface SmsService {

    List<SmsSendRecord> getSmsSendRecord(User user);

}
