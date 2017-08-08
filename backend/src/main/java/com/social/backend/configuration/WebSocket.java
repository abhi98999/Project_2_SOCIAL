package com.social.backend.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
@ComponentScan(basePackages="com.social")
public class WebSocket extends AbstractWebSocketMessageBrokerConfigurer {

	
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// 
		super.configureMessageBroker(registry);
		registry.enableSimpleBroker("/topic","/queue");
		registry.setApplicationDestinationPrefixes("/app");
	}

	public void registerStompEndpoints(StompEndpointRegistry arg0) {
	arg0.addEndpoint("/chat").withSockJS();

	}

}
