package com.osd.ssop.controller;

import com.osd.ssop.entity.SmsBuyRecord;
import com.osd.ssop.entity.User;
import com.osd.ssop.service.ManagerService;
import com.osd.ssop.service.PayService;
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
public class PayController {

    @Autowired
    private PayService payService;

    @Autowired
    private ManagerService managerService;

    @RequestMapping("pay/pay_buy_record")
    public ModelAndView buyRecord(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        User user = managerService.getUserByName(username);
        List<SmsBuyRecord> buyRecordList = payService.getSmsBuyRecord(user);
        ModelAndView mv = new ModelAndView("pay/pay_buy_record", "buyRecordList", buyRecordList);
        return mv;
    }

    @RequestMapping("pay/pay_buy_sms")
    public ModelAndView buySms() {
        ModelAndView mv = null;
        return mv;
    }

}
