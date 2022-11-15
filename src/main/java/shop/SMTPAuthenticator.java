package shop;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SMTPAuthenticator extends javax.mail.Authenticator {
    public PasswordAuthentication getPasswordAuthenticattion(String from, String emailPasword){
        return new PasswordAuthentication(from, emailPasword);
    }
}
