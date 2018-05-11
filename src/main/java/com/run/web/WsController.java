package com.run.web;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.run.domain.WiselyMessage;
import com.run.domain.WiselyResponse;



@Controller
public class WsController {
	@MessageMapping("/welcome")
	@SendTo("/topic/getResponse")
	public WiselyResponse say(WiselyMessage message) throws Exception{
			Thread.sleep(3000);
		return new WiselyResponse("Welcome , " +message.getName() + "!");
	}
	
//	@MessageMapping("/ws")
//	public String toWs() {
//		return "ws";
//	}

}
