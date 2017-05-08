package com.osd.ssop.service;

import com.osd.ssop.entity.SmsBuyRecord;
import com.osd.ssop.entity.User;

import java.util.List;

/**
 * Created by chenbinghao on 17/4/15.下午9:03
 */
public interface PayService {

    List<SmsBuyRecord> getSmsBuyRecord(User user);

}
