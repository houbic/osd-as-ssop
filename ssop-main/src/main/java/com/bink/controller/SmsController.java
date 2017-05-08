package com.bink.controller;

import com.bink.entity.SmsSendRecord;
import com.bink.entity.User;
import com.bink.service.ManagerService;
import com.bink.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by chenbinghao on 16/9/14.上午10:00
 */
@Controller
@RequestMapping("message")
public class SmsController implements MyController {

    @Autowired
    private ManagerService managerService;


    @Autowired
    private SmsService smsService;

    @RequestMapping("sms/sms_send_record")
    public ModelAndView buyRecord(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        User user = managerService.getUserByName(username);
        List<SmsSendRecord> sendRecordList = smsService.getSmsSendRecord(user);
        sendRecordList.forEach(sendRecord -> {
            sendRecord.setDescMobiles(null);
            sendRecord.setSendContent(null);
        });
        ModelAndView mv = new ModelAndView("sms/sms_send_record", "sendRecordList", sendRecordList);
        return mv;
    }

    @RequestMapping("sms/sms_send")
    public ModelAndView sendSms(HttpServletRequest request, HttpServletResponse response) {
        User user = getUser(request, managerService);
        ModelAndView mv = new ModelAndView("sms/sms_send");
        return mv;
    }




}
