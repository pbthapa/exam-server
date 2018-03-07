package com.lis.exam.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ExamController {

	@MessageMapping("/message")
	@SendTo("/topic/exam")
	public String send(String message) throws Exception {
		return message;
}

	
}
