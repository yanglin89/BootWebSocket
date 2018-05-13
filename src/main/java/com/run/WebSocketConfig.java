package com.run;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
//通过@EnableWebSocketMessageBroker 开启使用STOMP协议来传输给予代理（message broker）的消息
//此时控制器支持@MessageMapping就像使用@RequestMapping一样
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	@Override
	public void registerStompEndpoints(StompEndpointRegistry register) {
		register.addEndpoint("/endpointWisely").withSockJS(); //注册一个名为 /endpointWisely 的endpoint
		register.addEndpoint("/endpointChat").withSockJS();
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker("/queue","/topic"); //广播式配置/topic消息代理；点对点式配置/queue消息代理
	}
	
	

}
