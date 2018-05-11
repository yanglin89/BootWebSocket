package com.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.ui.Model;


@SpringBootApplication
public class BootWebSocketApplication {
	
	
	//@RequestMapping("/show")
	@MessageMapping("/show")
	public String index(Model model) {
		System.out.println("11111111111111111111");
		
		return "ws";
	}

	public static void main(String[] args) {
		SpringApplication.run(BootWebSocketApplication.class, args);
	}
}
