package com.rabbitmq.queue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.domain.MenuOrder;

@Component
@RabbitListener(queues = "rabbitmq.queue", id = "listener")
public class RabbitMQReceiver {

	private static Logger logger = LogManager.getLogger(RabbitMQReceiver.class.toString());

	@RabbitHandler
	public void receiver(MenuOrder menuOrder) {
		logger.info("MenuOrder listener invoked - Consuming Message with MenuOrder Identifier : "
				+ menuOrder.getOrderIdentifier());
	}

}