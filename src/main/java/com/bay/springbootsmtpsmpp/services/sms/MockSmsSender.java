package com.bay.springbootsmtpsmpp.services.sms;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MockSmsSender implements SmsSender {

    private static Log log = LogFactory.getLog(MockSmsSender.class);

    @Override
    public void sendSms(String message, String toNumber) {
        log.info("Sms Sent via Mock Sms Sender.");
    }
}