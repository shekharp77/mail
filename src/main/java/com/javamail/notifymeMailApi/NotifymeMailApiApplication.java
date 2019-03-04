package com.javamail.notifymeMailApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackageClasses = com.javamail.notifymeMailApi.mailer.class)
@ComponentScan(basePackageClasses = com.javamail.notifymeMailApi.rest.class)
@EnableAutoConfiguration
@SpringBootApplication
public class NotifymeMailApiApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(NotifymeMailApiApplication.class, args);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

//		public void run(String[]args){
//			//Write Code here to executes when application starts running
//			System.out.println("********** Project Started Running");
//		}
	}
}
