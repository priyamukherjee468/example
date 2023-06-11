package org.example;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class CustomizeMailAuthentication extends Authenticator {
    @Override
    protected PasswordAuthentication getPasswordAuthentication()
    {
        return new PasswordAuthentication(MailMetadata.myUserMail,MailMetadata.password);

    }
}
