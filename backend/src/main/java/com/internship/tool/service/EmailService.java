package com.internship.tool.service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public void sendRequestMail(String toEmail) {
        System.out.println("Request mail sent to: " + toEmail);
    }

    public void sendApprovalMail(String toEmail) {
        System.out.println("Approval mail sent to: " + toEmail);
    }

    public void sendRejectionMail(String toEmail) {
        System.out.println("Rejection mail sent to: " + toEmail);
    }
}