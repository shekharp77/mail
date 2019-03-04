package com.javamail.notifymeMailApi;

import java.io.UnsupportedEncodingException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class RestApi {
//    //retrieveProfile API Url
//    @CrossOrigin
//    @RequestMapping(value ="/signinmail", method = RequestMethod.GET, produces = "application/json")
//    public boolean sign(
//            @RequestParam("username") String username,
//            @RequestParam("password") String password,
//            @RequestParam("name") String name
//    ) {
//        Mailer.user = username;
//        Mailer.pass = password;
//        Mailer.name = name;
//        try {
//            Mailer.connect();
//        } catch (MessagingException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return false;
//        }
//        System.out.println("credentials "+username+" "+password+" "+name);
//        return true;
//    }


    @CrossOrigin
    @RequestMapping(value ="/sendmail", method = RequestMethod.POST, produces = "application/json")
    public boolean sendmail(
            @RequestParam("recipient") String recipient,
            @RequestParam("sub") String subject,
            @RequestParam("msg") String msg,
            @RequestParam("name") String name
    ) {
        try {
            Mailer.send(recipient, subject, msg, name);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

