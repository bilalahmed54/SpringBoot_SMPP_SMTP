package com.bay.springbootsmtpsmpp.services.sms;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SmppSmsSender implements SmsSender {

    private static Log log = LogFactory.getLog(SmppSmsSender.class);

    @Override
    public void sendSms(String message, String toNumber) {
        log.info("Sms Sent via SMPP Sms Sender.");
    }
}