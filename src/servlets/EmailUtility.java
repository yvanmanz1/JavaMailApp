package servlets;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailUtility {

    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final String SMTP_PORT = "587";
    private static final String EMAIL_FROM = "manziy20@gmail.com";
    private static final String EMAIL_PASSWORD = "jjjj";

    public static void sendConfirmationEmail(String toEmail, String subject, String body) throws MessagingException {
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", SMTP_HOST);
        properties.setProperty("mail.smtp.port", SMTP_PORT);
        properties.setProperty("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties, null);

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(EMAIL_FROM));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
        message.setSubject(subject);
        message.setText(body);

        Transport transport = session.getTransport("smtp");
        transport.connect(SMTP_HOST, EMAIL_FROM, EMAIL_PASSWORD);

        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
