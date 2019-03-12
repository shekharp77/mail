package mail;

import mail.RestApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import javax.mail.MessagingException;


@ComponentScan(basePackageClasses = com.javamail.notifymeMailApi.Mailer.class)
@ComponentScan(basePackageClasses = RestApi.class)
@EnableAutoConfiguration
@SpringBootApplication
public class Notify implements CommandLineRunner {

	public static void main(String[] args)  {
		try {
			SpringApplication.run(Notify.class, args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}


	public void run(String[] args){
		try {
			com.javamail.notifymeMailApi.Mailer.connect();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		//Write Code here to executes when application starts running
		System.out.println("********** Project Started Running");
	}
}
