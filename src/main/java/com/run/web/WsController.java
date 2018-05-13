package com.run.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.run.domain.WiselyMessage;
import com.run.domain.WiselyResponse;

@Controller
public class WsController {
	
	@Autowired
	private SimpMessagingTemplate messagingTemplate; //通过SimpMessagingTemplate向浏览器发送消息
	
	@MessageMapping("/welcome")
	@SendTo("/topic/getResponse")
	public WiselyResponse say(WiselyMessage message) throws Exception{
			Thread.sleep(3000);
		return new WiselyResponse("Welcome , " +message.getName() + "!");
	}
	
	/**
	 * @param principal 在springmvc中，可以直接获得principal，principal中包含了当前用户的信息
	 * @param msg
	 */
	@MessageMapping("/chat")
	public void handleChat(Principal principal,String msg) {
		if(principal.getName().equals("yl")) {
			messagingTemplate.convertAndSendToUser("lhy", "/queue/notifications", principal.getName() + "-send:" + msg);
		}else {
			messagingTemplate.convertAndSendToUser("yl", "/queue/notifications", principal.getName() + "-send:" + msg);

		}
	}
	

}
