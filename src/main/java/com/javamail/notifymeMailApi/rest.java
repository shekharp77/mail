package com.javamail.notifymeMailApi;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class rest {
    //retrieveProfile API Url
    @CrossOrigin
    @RequestMapping(value ="/signinmail", method = RequestMethod.GET, produces = "application/json")
    public boolean sign(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("name") String name
    ) {
        mailer.user = username;
        mailer.pass = password;
        mailer.name = name;
        try {
            mailer.connect();
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        System.out.println("credentials "+username+" "+password+" "+name);
        return true;
    }


    @CrossOrigin
    @RequestMapping(value ="/sendmail", method = RequestMethod.GET, produces = "application/json")
    public boolean sendmail(
            @RequestParam("recipient") String recipient,
            @RequestParam("sub") String subject,
            @RequestParam("msg") String msg
    ) {
        try {
            mailer.send(recipient, subject, msg);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

