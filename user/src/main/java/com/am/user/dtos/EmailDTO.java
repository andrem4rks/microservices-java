package com.am.user.dtos;

import java.util.UUID;

public class EmailDTO {

    private UUID userId;
    private String emailTo;
    private String subject;
    private String text;

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }
}
