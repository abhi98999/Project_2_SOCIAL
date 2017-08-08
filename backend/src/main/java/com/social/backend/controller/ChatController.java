package com.social.backend.controller;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.social.backend.model.Message;
import com.social.backend.model.OutputMessage;


@Controller
public class ChatController {
	
	private static final Logger log = LoggerFactory.getLogger(ChatController.class);

	@MessageMapping("/chat")
	@SendTo("/topic/message")
	public OutputMessage sendMessage(Message message){
		log.debug("Calling the method sendMessage");
		log.debug("Message :-",message.getMessage());
		log.debug("Message Id:-",message.getId());
		return new OutputMessage(message,new Date());
	}
}
