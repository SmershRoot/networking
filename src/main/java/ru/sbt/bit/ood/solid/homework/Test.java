package ru.sbt.bit.ood.solid.homework;

import javax.mail.MessagingException;
import java.sql.Connection;

public class Test {
    public static void main( String args[] ) {
        Connection databaseConnection = null;
        SalaryHtmlReportNotifier salaryHtmlReportNotifier=new SalaryHtmlReportNotifier(databaseConnection);
        StringBuffer resultingHtml = salaryHtmlReportNotifier.generateHtmlSalaryReport("1",
                null,null);

        try {
            String recipients="me";
            MailMessage mailMessage = new MailMessage(recipients, "Monthly department salary report", resultingHtml.toString(), true);
            if (!SendingMailManager.sendMassege(mailMessage)) {
                throw new MessagingException("Отправка почты не была произведена");
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
