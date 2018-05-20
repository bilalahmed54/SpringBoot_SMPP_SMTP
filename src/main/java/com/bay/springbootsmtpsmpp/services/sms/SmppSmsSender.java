package com.bay.springbootsmtpsmpp.services.sms;

import com.twilio.Twilio;
import com.twilio.type.PhoneNumber;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Value;

public class SmppSmsSender implements SmsSender {

    private static Log log = LogFactory.getLog(SmppSmsSender.class);

    @Value("${Twilio.Account_Sid}")
    String account_sid;

    @Value("${Twilio.Auth_Token}")
    String auth_token;

    @Value("${Twilio.Phone_Number}")
    String twilio_phone_number;

    @Override
    public void sendSms(String message, String toNumber) {

        log.info("Sms Sent via SMPP Sms Sender.");

        Twilio.init(account_sid, auth_token);

        if(!toNumber.startsWith("+")) {
            toNumber = "+" + toNumber;
        }

        Message.creator(new PhoneNumber(toNumber), new PhoneNumber(twilio_phone_number), message).create();
    }
}