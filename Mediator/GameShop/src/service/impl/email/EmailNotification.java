package service.impl.email;

import service.interfaces.INotification;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class EmailNotification implements INotification {
    final boolean auth = true;
    final boolean startTls = true;
    final String host = "smtp.sendgrid.net";
    final Integer smtpPort = 587;
    final String username = "username";
    final String password = "key";

    public EmailNotification() {}

    @Override
    public CompletableFuture<Void> send(String content, String replyTo) {
        return CompletableFuture.runAsync(() -> {
           try {
               var session = getSession();
               var message = makeMessage(session, replyTo, content);
               Transport.send(message);
           } catch (MessagingException e) {
               throw new RuntimeException("Erro ao enviar mensagem no email!", e);
           }
        }).orTimeout(30, TimeUnit.SECONDS);
    }

    private Session getSession() {
        var props = new Properties();
        props.put("mail.smtp.auth", auth);
        props.put("mail.smtp.starttls.enable", startTls);
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", smtpPort.toString());
        return Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }

    private Message makeMessage(Session session, String email, String content) throws MessagingException {
        var message = new MimeMessage(session);
        message.setFrom(new InternetAddress(email));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("destinatario@exemplo.com"));
        message.setSubject("No Reply");
        message.setText(content);
        return message;
    }
}
