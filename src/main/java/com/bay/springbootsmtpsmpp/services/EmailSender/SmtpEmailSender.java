package com.bay.springbootsmtpsmpp.services.EmailSender;

import javax.mail.MessagingException;
import org.apache.commons.logging.Log;
import javax.mail.internet.MimeMessage;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.beans.factory.annotation.Autowired;

public class SmtpEmailSender implements EmailSender {

    @Autowired
    private JavaMailSender javaMailSender;
    private static Log log = LogFactory.getLog(MockEmailSender.class);

    @Override
    public void sendEmail(String subject, String body, String toAddress) throws MessagingException {

        log.info("Sending Email via SMTP Email Sender.");

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setTo(toAddress);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(body, true);

        javaMailSender.send(mimeMessage);
    }
}