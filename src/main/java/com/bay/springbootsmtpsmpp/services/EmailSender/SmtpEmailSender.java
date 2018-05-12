package com.bay.springbootsmtpsmpp.services.EmailSender;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SmtpEmailSender implements EmailSender {

    private static Log log = LogFactory.getLog(MockEmailSender.class);

    @Override
    public void sendEmail(String subject, String body, String toAddress) {
        log.info("Sending Email via SMTP Email Sender.");
    }
}