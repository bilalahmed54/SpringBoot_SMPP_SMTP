package com.bay.springbootsmtpsmpp.services.email;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MockEmailSender implements EmailSender {

    private static Log log = LogFactory.getLog(MockEmailSender.class);

    @Override
    public void sendEmail(String subject, String body, String toAddress) {
        log.info("Sending Email via Mock Email Sender.");
    }
}