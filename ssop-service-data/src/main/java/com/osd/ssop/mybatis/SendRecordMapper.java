package com.osd.ssop.mybatis;

import com.osd.ssop.entity.SmsSendRecord;

import java.util.List;

/**
 * Created by chenbinghao on 17/4/15.下午10:43
 */
public interface SendRecordMapper {

    List<SmsSendRecord> querySendRecord(int accountId);

}
