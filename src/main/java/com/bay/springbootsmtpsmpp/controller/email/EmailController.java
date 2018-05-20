package com.bay.springbootsmtpsmpp.controller.email;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.bay.springbootsmtpsmpp.services.email.EmailSender;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;

@RestController
public class EmailController {

    @Value("${app.name}")
    String appName;

    //Dependency Injection
    private EmailSender emailSender;

    private static Log log = LogFactory.getLog(EmailController.class);

    @Autowired
    public EmailController(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    //Just for the testing purpose
    @RequestMapping("/email/index")
    public String index() {
        return "Hello World: Welcome to Application: " + appName;
    }

    //Sending actual emails
    @RequestMapping("/sendEmail")
    public String send(@RequestParam String subject, @RequestParam String body, @RequestParam String toAddress) throws MessagingException {

        log.info("Going to Send Email with the following Details: ");
        log.info("Subject: " + subject + "\n Body: " + body + "\n Email Address: " + toAddress);

        //emailSender.sendEmail("Test Email", "Test Email Sent via Spring Boot Application", "bilalahmedpu@gmail.com");

        try {
            emailSender.sendEmail(subject, body, toAddress);
            log.info("Email Has Been Sent Successfully!");
            return "Email Has Been Sent Successfully!";
        } catch (Exception ex) {
            log.info("Some Error Occurred While Sending an Email. See Error Logs for More Details.");
            log.error("Exception Occurred While Sending an Email: ", ex);
            return "Some Error Occurred While Sending an Email. See Error Logs for More Details.";
        }
    }
}