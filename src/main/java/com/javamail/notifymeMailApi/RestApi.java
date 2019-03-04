package com.javamail.notifymeMailApi;

import java.io.UnsupportedEncodingException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class RestApi {

    @CrossOrigin
    @RequestMapping(value ="/sendmail/message", method = RequestMethod.POST, produces = "application/json")
    public boolean sendMessage(
            @RequestParam("recipient") String recipient,
            @RequestParam("sub") String subject,
            @RequestParam("msg") String msg,
            @RequestParam("name") String name
    ) {
        try {
            Mailer.sendMessage(recipient, subject, msg, name);
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @CrossOrigin
    @RequestMapping(value ="/sendmail/html", method = RequestMethod.POST, produces = "application/json")
    public boolean sendHtml(
            @RequestParam("recipient") String recipient,
            @RequestParam("sub") String subject,
            @RequestParam("html") String html,
            @RequestParam("name") String name
    ) {
        Mailer.sendHtml(recipient, subject, html, name);
        return true;

    }

    @CrossOrigin
    @RequestMapping(value ="/sendmail/message/file", method = RequestMethod.POST, produces = "application/json")
    public boolean sendMessageWithFile(
            @RequestParam("recipient") String recipient,
            @RequestParam("sub") String subject,
            @RequestParam("msg") String msg,
            @RequestParam("name") String name,
            @RequestParam("url") String url
    ) {
        try {
            Mailer.sendMessageWithFile(recipient, subject, msg, name, url);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return true;
    }

    @CrossOrigin
    @RequestMapping(value ="/sendmail/file", method = RequestMethod.POST, produces = "application/json")
    public boolean sendOnlyFile(
            @RequestParam("recipient") String recipient,
            @RequestParam("sub") String subject,
            @RequestParam("name") String name,
            @RequestParam("url") String url
    ){
        Mailer.sendOnlyFile(recipient, subject, name, url);
        return true;
    }
}

