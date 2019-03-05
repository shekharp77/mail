package com.javamail.notifymeMailApi;

import java.io.UnsupportedEncodingException;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class RestApi {

    @CrossOrigin
    @RequestMapping(value ="/sendmail/v1/message", method = RequestMethod.POST, produces = "application/json")
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
    @RequestMapping(value ="/sendmail/v1/html", method = RequestMethod.POST, produces = "application/json")
    public boolean sendHtml(
            @RequestParam("recipient") String recipient,
            @RequestParam("sub") String subject,
            @RequestParam("html") String html,
            @RequestParam("name") String name
    ) {
        Mailer.sendHtml(recipient, subject, name, html);
        return true;

    }

    @CrossOrigin
    @RequestMapping(value ="/sendmail/v1/message/file", method = RequestMethod.POST, produces = "application/json")
    public boolean sendMessageWithFile(
            @RequestParam("recipient") String recipient,
            @RequestParam("sub") String subject,
            @RequestParam("msg") String msg,
            @RequestParam("name") String name,
            @RequestParam("url") String url
    ) {
        try {
            String file =  Paths.get(".", "src/main/resources",url ).normalize().toFile().toString();
            Mailer.sendMessageWithFile(recipient, subject, msg, name, file);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return true;
    }

    @CrossOrigin
    @RequestMapping(value ="/sendmail/v1/file", method = RequestMethod.POST, produces = "application/json")
    public boolean sendOnlyFile(
            @RequestParam("recipient") String recipient,
            @RequestParam("sub") String subject,
            @RequestParam("name") String name,
            @RequestParam("url") String url
    ){
        String file =  Paths.get(".", "src/main/resources",url ).normalize().toFile().toString();
        Mailer.sendOnlyFile(recipient, subject, name, file);
        return true;
    }

}

