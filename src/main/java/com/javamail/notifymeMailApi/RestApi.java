package com.javamail.notifymeMailApi;

import java.io.UnsupportedEncodingException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class RestApi {

    @CrossOrigin
    @RequestMapping(value ="/sendmail", method = RequestMethod.POST, produces = "application/json")
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

    //public boolean sendHtml(){}

   // public boolean sendMessageWithFile() {}

    //public boolean sendFile(){}
}

