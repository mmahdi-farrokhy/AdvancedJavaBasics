package shop;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import javax.mail.Session;
import javax.mail.Transport;

public class EmailServiceImpl implements EmailService{
    private static final String host = "localhost";
    private static final String SMTPServer = "smtp.gmail.com";
    private static final String SMTPPort = "25";
    private static String Subject = "";

    public EmailServiceImpl(String Subject) {
        this.Subject = Subject;
    }

    @Override
    public void sendEmail(String from, String emailPassword,  String to, String emailText) {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", SMTPServer);
        properties.setProperty("mail.smtp.port", SMTPPort);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, emailPassword);
                    }
                });

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setText(emailText);
            msg.setSubject(Subject);
            msg.setFrom(new InternetAddress(from));
            msg.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(to)));
            Transport.send(msg);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}