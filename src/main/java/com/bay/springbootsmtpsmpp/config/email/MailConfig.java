package com.bay.springbootsmtpsmpp.config.email;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Configuration;
import com.bay.springbootsmtpsmpp.services.email.EmailSender;
import com.bay.springbootsmtpsmpp.services.email.MockEmailSender;
import com.bay.springbootsmtpsmpp.services.email.SmtpEmailSender;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@Configuration
public class MailConfig {

    @Bean
    @Profile({"dev", "test"})
    @ConditionalOnProperty(name = "spring.mail.host", matchIfMissing = true)
    public EmailSender mockEmailSender() {
        return new MockEmailSender();
    }

    @Bean
    @Profile("prod")
    @ConditionalOnProperty(name = "spring.mail.host", matchIfMissing = false)
    public EmailSender smtpEmailSender() {
        return new SmtpEmailSender();
    }
}