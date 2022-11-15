package shop;

public interface EmailService {
    void sendEmail(String from, String emailPassword, String to, String emailText);
}
