package com.bay.springbootsmtpsmpp.controller;

import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bay.springbootsmtpsmpp.services.EmailSender.EmailSender;

@RestController
public class EmailController {

    @Value("${app.name}")
    String appName;

    //Dependency Injection
    private EmailSender emailSender;

    @Autowired
    public EmailController(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    //Just for the testing purpose
    @RequestMapping("/index")
    public String index() {
        return "Hello World: Welcome to Application: " + appName;
    }

    //Sending actual emails
    @RequestMapping("/sendEmail")
    public String send() throws MessagingException {

        emailSender.sendEmail("Test Email", "Test Email Sent via Spring Boot Application", "bilalahmedpu@gmail.com");
        return "Email Sent!";
    }
}