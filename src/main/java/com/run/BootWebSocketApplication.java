package com.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.ui.Model;


@SpringBootApplication
public class BootWebSocketApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BootWebSocketApplication.class, args);
	}
}
