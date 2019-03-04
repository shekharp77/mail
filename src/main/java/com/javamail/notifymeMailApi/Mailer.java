package com.javamail.notifymeMailApi;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mailer {
    static String user = "hashedin.notify@gmail.com";
    static String pass = "Hasher@123";
    static Transport transport;
    static Session session;

    //Connecting to Server
    public static void connect() throws MessagingException{
        java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
        //1st step) Get the session object
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.put("mail.from", user);
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.debug", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(user,pass);
                    }
                });
        transport = session.getTransport("smtp");

        transport.connect(user, pass);
    }

    // To send a mail just call this method with classname because it is a static method e.g. Mailer.send("to","subject","message");
    public static void sendMessage(String to,String subject,String msg, String name) throws UnsupportedEncodingException{

        //2nd step)compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user,name));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject(subject);
            message.setContent(
                    "<h1>This is actual message embedded in HTML tags by "+name+ " : "+msg+"</h1>",
                    "text/html");
            message.setText(msg);
            transport.sendMessage(message, message.getAllRecipients());

        } catch (MessagingException e) {
            System.out.print(e);

        }

    }




    // To send a mail just call this method with classname because it is a static method e.g. Mailer.send("to","subject","message");
    public static void sendMessageWithFile(String to,String subject,String msg, String name, String url) throws UnsupportedEncodingException{


        try {
            System.out.println("**************************************************");
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user,name));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject(subject);
            message.setText(msg);
            Multipart multipart = new MimeMultipart();

            // Part two is attachment
            BodyPart messageBodyPart = new MimeBodyPart();
            String filename = url;
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);


            // Send the complete message parts
            message.setContent(multipart);
            transport.sendMessage(message, message.getAllRecipients());

            System.out.println("*****************************Done**************************");

        } catch (MessagingException e) {


            System.out.println(e);
        }
    }

    public static void sendHtml(String to,String subject, String name, String htmltemplate) {
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user,name));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject(subject);
            message.setContent(htmltemplate,
                    "text/html");
            transport.sendMessage(message, message.getAllRecipients());

        } catch (MessagingException e) {
            System.out.print(e);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void sendOnlyFile(String to,String subject,String name, String url) {

        try {
            System.out.println("**************************************************");
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user,name));
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject(subject);
//            message.setText(msg);
            Multipart multipart = new MimeMultipart();

            // Part two is attachment
            BodyPart messageBodyPart = new MimeBodyPart();
            String filename = url;
            DataSource source = new FileDataSource(filename);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filename);
            multipart.addBodyPart(messageBodyPart);


            // Send the complete message parts
            message.setContent(multipart);
            transport.sendMessage(message, message.getAllRecipients());

            System.out.println("*****************************Done**************************");

        } catch (MessagingException e) {


            System.out.println(e);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}

