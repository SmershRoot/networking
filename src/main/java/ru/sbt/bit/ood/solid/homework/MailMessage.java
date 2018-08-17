package ru.sbt.bit.ood.solid.homework;

import java.util.ArrayList;
import java.util.List;

public class MailMessage {
    List<String> addressMails = new ArrayList<String>();
    private String subject;
    private String message;
    private boolean isHtml;

    public MailMessage(List<String> addressMails, String subject, String message, boolean isHtml) {
        this.addressMails=addressMails;
        this.subject = subject;
        this.message = message;
        this.isHtml = isHtml;
    }

    public MailMessage(String addressMails, String subject, String message, boolean isHtml) {
        this.addressMails.add(addressMails);
        this.subject = subject;
        this.message = message;
        this.isHtml = isHtml;
    }

    public String[] getAddressMail() {
        return addressMails.toArray(new String[addressMails.size()]);
    }

    public void addAddressMails(List<String> addressMail) {
        this.addressMails.addAll(addressMails);
    }

    public void addAddressMail(String addressMail) {
        this.addressMails.add(addressMail);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isHtml() {
        return isHtml;
    }

    public void setHtml(boolean html) {
        isHtml = html;
    }
}