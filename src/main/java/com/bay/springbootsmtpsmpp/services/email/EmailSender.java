package com.bay.springbootsmtpsmpp.services.email;

import javax.mail.MessagingException;

public interface EmailSender {

    void sendEmail(String subject, String body, String toAddress) throws MessagingException;
}