package com.bink.mybatis;

import com.bink.entity.SmsBuyRecord;

import java.util.List;

/**
 * Created by chenbinghao on 17/4/15.下午9:10
 */
public interface BuyRecordMapper {

    List<SmsBuyRecord> queryBuyRecord(int accountId);

}
