package shop;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import javax.mail.Message.RecipientType;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Session;
import javax.mail.Transport;

public class EmailServiceImpl implements EmailService{
    private static String host = "localhost";
    private static String SMTPServer = "smtp.gmail.com";
    private static String SMTPPort = "465";
    private static String Subject = "Shopping List";

    @Override
    public void sendEmail(String from, String emailPassword,  String to, String emailText) {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", SMTPServer);

        Session session = Session.getDefaultInstance(properties);

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
