package com.itzidan.utils;


import com.itzidan.domain.SMail;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.mail.*;
import java.util.Properties;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Data
@Component
@ConfigurationProperties(prefix = "mail")
public class SMTP_Mail {
    static String password;
    static String qqaccount;
    public String getQqaccount() {
        return qqaccount;
    }
    @Value("${mail.qqaccount}")
    public void setQqaccount(String qqaccount) {
        SMTP_Mail.qqaccount = qqaccount;
    }
    public String getPassword() {
        return password;
    }
    @Value("${mail.password}")
    public void setPassword(String password) {
        SMTP_Mail.password = password;
    }

    public static void send(SMail mail) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.qq.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.user", qqaccount);
        props.put("mail.password", password);
        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        Session mailSession = Session.getInstance(props, authenticator);
        MimeMessage message = new MimeMessage(mailSession);
        try {
            InternetAddress from = new InternetAddress(props.getProperty("mail.user"));
            message.setFrom(from);
            InternetAddress to = new InternetAddress(mail.getTo());
            message.setRecipient(Message.RecipientType.TO, to);
            message.setSubject(mail.getSubject());
            message.setContent(mail.getContent(), "text/html;charset=UTF-8");
            Transport.send(message);
            System.out.println("ok");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {


    }
}
