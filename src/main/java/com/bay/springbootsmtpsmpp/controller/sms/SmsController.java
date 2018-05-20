package com.bay.springbootsmtpsmpp.controller.sms;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.bay.springbootsmtpsmpp.services.sms.SmsSender;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class SmsController {

    private SmsSender smsSender;
    private static Log log = LogFactory.getLog(SmsController.class);

    @Autowired
    public void setSmsSender(SmsSender smsSender) {
        this.smsSender = smsSender;
    }

    @RequestMapping("/sms/index")
    public String index() {
        return "Hello SMS World";
    }

    @RequestMapping("sendSms")
    public String sendSms(@RequestParam String message, @RequestParam String toNumber) {

        log.info("Going to Send Email with the following Details: ");
        log.info("Message: " + message + "\n Phone Number: " + toNumber);

        try {
            smsSender.sendSms(message, toNumber);
            log.info("SMS Has Been Sent Successfully!");
            return "SMS Has Been Sent Successfully!";
        } catch (Exception ex) {
            log.info("Some Error Occurred While Sending an SMS. See Error Logs for More Details.");
            log.error("Exception Occurred While Sending an SMS: ", ex);
            return "Some Error Occurred While Sending an SMS. See Error Logs for More Details.";
        }
    }
}