package ru.sbt.bit.ood.solid.homework;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendingMailManager {
    private static final Logger LOG = LoggerFactory.getLogger(SendingMailManager.class);

    public static boolean sendMassege(MailMessage mailMessage){
        try {
            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

            mailSender.setHost("mail.google.com");

            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(mailMessage.getAddressMail());
            helper.setSubject(mailMessage.getSubject());
            // setting message text, last parameter 'true' says that it is HTML format
            helper.setText(mailMessage.getMessage(), mailMessage.isHtml());
            mailSender.send(message);
            return true;
        } catch (Exception ex) {
            LOG.warn("Ошибка отправки почты:" + ex.getMessage());
        }
        return false;
    }
}
