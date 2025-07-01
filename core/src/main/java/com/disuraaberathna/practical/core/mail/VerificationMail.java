package com.disuraaberathna.practical.core.mail;

import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;

public class VerificationMail extends Mailable {
    private final String to;
    private final String verificationCode;

    public VerificationMail(String to, String verificationCode) {
        this.to = to;
        this.verificationCode = verificationCode;
    }

    @Override
    public void build(Message message) throws Exception {
        message.setRecipients(Message.RecipientType.TO, new InternetAddress[]{new InternetAddress(to)});
        message.setSubject("Verification Mail");
        message.setText("Your verification code is: " + verificationCode);
    }
}
