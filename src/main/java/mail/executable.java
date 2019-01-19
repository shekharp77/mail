package mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackageClasses = mail.mailer.class)
@ComponentScan(basePackageClasses = mail.rest.class)
@EnableAutoConfiguration
@SpringBootApplication
public class executable {
	public static void main(String[] args) {
		try {
			SpringApplication.run(executable.class, args);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	public void run(String... args) throws Exception {
		//Write Code here to executes when application starts running
		System.out.println("********** Project Started Running");
	}
}
