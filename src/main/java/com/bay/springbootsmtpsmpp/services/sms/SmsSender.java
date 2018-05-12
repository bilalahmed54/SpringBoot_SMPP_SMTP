package com.bay.springbootsmtpsmpp.services.sms;

public interface SmsSender {

    public void sendSms(String message, String toNumber);
}