// A class for any functionality I want to occur on start-up (mostly for testing)

package com.olsonja.portfolio2;

import com.olsonja.portfolio2.data.DataSeeder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import org.apache.log4j.Logger;

import com.olsonja.portfolio2.model.EmailRequest;
import com.olsonja.portfolio2.service.EmailService;

// @Component
public class Initializer implements CommandLineRunner {

    private static final Logger logger = Logger.getLogger(Initializer.class);

    private EmailService emailService;

    public Initializer(EmailService emailService) {
        this.emailService = emailService;
    }

    public void run(String... args) {

        // Send email to myself
        try {

            EmailRequest emailRequest = new EmailRequest("John", "Olson", "olsonja88@gmail.com", "Your Spring Boot App has started.");
            emailService.sendEmail(emailRequest);

        } catch(Exception e) {
            System.out.println("*** AN EXCEPTION HAS OCCURRED ***:" + e);
            logger.error("An exception has occurred: " + e);
        }
    }
}
