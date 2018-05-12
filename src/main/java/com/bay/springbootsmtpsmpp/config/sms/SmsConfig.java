package com.bay.springbootsmtpsmpp.config.sms;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Configuration;
import com.bay.springbootsmtpsmpp.services.sms.SmsSender;
import com.bay.springbootsmtpsmpp.services.sms.MockSmsSender;
import com.bay.springbootsmtpsmpp.services.sms.SmppSmsSender;

@Configuration
public class SmsConfig {

    @Bean
    @Profile({"dev", "test"})
    public SmsSender mockSmsSender() {
        return new MockSmsSender();
    }

    @Bean
    @Profile("prod")
    public SmsSender smppSmsSender() {
        return new SmppSmsSender();
    }
}