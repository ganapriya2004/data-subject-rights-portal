package com.internship.tool.scheduler;

import com.internship.tool.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RequestScheduler {

    @Autowired
    private EmailService emailService;

    // Runs every 60 seconds
    @Scheduled(fixedRate = 60000)
    public void checkRequests() {

        System.out.println("Scheduler running...");

        // Dummy email for testing
        String testEmail = "test@gmail.com";

        // ✅ This method MUST exist in EmailService
        emailService.sendApprovalMail(testEmail);
    }
}
