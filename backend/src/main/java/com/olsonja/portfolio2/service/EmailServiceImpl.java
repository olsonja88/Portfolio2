package com.olsonja.portfolio2.service;

import com.olsonja.portfolio2.model.EmailRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public void sendEmail(EmailRequest emailRequest) {

        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try {
            helper.setTo("olsonja88@gmail.com");
            helper.setSubject("Message from: " + emailRequest.getFirstName() + " " + emailRequest.getLastName() + " " + emailRequest.getEmail());
            helper.setText(emailRequest.getMessage(), true);

            emailSender.send(message);
        } catch (Exception e) {
            System.out.println("*** AN EXCEPTION HAS OCCURRED ***:" + e);
        }
    }

}
