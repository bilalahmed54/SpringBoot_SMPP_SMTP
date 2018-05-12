package com.bay.springbootsmtpsmpp.services.EmailSender;

public interface EmailSender {

    void sendEmail(String subject, String body, String toAddress);
}