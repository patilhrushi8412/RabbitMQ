package com.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabbitmq.domain.MenuOrder;
import com.rabbitmq.queue.RabbitMQSender;

@RestController
@RequestMapping(value = "/rabbitmq")
public class RabbitMQController {

	@Autowired
	RabbitMQSender rabbitMQSender;

	@PostMapping(value = "/sender")
	public String producer(@RequestBody MenuOrder menuOrder) {
		rabbitMQSender.send(menuOrder);
		return "Message sent to the RabbitMQ Queue Successfully";
	}
}