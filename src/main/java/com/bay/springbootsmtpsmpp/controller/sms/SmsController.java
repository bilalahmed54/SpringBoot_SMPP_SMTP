package com.bay.springbootsmtpsmpp.controller.sms;

import com.bay.springbootsmtpsmpp.services.sms.SmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class SmsController {

    private SmsSender smsSender;

    @Autowired
    public void setSmsSender(SmsSender smsSender) {
        this.smsSender = smsSender;
    }

    @RequestMapping("/sms/index")
    public String index() {
        return "Hello SMS World";
    }

    @RequestMapping("sendSms")
    public String sendSms() {

        smsSender.sendSms("Hello This is Test SMS by BAY Using Spring Boot Application", "");
        return "SMS Sent!";
    }
}