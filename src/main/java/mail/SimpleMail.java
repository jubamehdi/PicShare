package mail;

import java.security.Security;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author admin
 */
public class SimpleMail {

    public SimpleMail() {
    }

    public void sendMail(String username) throws Exception {
        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "smtp.gmail.com");

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        props.put("mail.debug", "true");
        props.put("mail.smtp.socketFactory.port", "465");

        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("picshare.welcome@gmail.com", "picshare123");
            }
        });
        session.setDebug(true);
        Transport transport = session.getTransport();
        InternetAddress addressFrom = new InternetAddress("picshare.welcome@gmail.com");
        MimeMessage message = new MimeMessage(session);
        message.setSender(addressFrom);

        message.setSubject("Bienvenue sur picshare");
        message.setContent("Bienvenue; vous êtes parfaitement inscrit sur notre site de partage d'images /n ", "text/plain");
        String sendTo[] = {username};
        if (sendTo != null) {
            InternetAddress[] addressTo = new InternetAddress[sendTo.length];
            for (int i = 0; i < sendTo.length; i++) {
                addressTo[i] = new InternetAddress(sendTo[i]);
            }
            message.setRecipients(Message.RecipientType.TO, addressTo);

        }
        transport.connect();
        transport.send(message);
        transport.close();
        System.out.println("DONE");

    }
}
