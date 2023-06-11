package org.example;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailHandler {
    void sendMail()
    {
        Properties sysProperties= System.getProperties();
        System.out.println(sysProperties);
        sysProperties.put("mail.smtp.host",MailMetadata.HostServer);
        sysProperties.put("mail.smtp.port",MailMetadata.port);
        sysProperties.put(MailMetadata.sslProperty,"true");
        sysProperties.put(MailMetadata.authPerm,"true");

        Authenticator mailAuthenticator=new CustomizeMailAuthentication();
        Session mailSession=Session.getInstance(sysProperties,mailAuthenticator);
        MimeMessage mailMessage=new MimeMessage(mailSession);
        try {
            mailMessage.setFrom(MailMetadata.myUserMail);
            mailMessage.setSubject("This is my java code testing");
            mailMessage.setText("Hey this is priya who is trying to send mail using java.");
            Address receiverEmail = new InternetAddress(MailMetadata.receiverMail);
            mailMessage.setRecipient(Message.RecipientType.TO,new InternetAddress(MailMetadata.receiverMail));
            Transport.send(mailMessage);
        }
        catch(Exception mailException){
            System.out.println(mailException.toString());
        }
    }
}
